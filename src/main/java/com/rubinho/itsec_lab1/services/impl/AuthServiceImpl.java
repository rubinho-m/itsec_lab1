package com.rubinho.itsec_lab1.services.impl;

import com.rubinho.itsec_lab1.exceptions.UnauthorizedException;
import com.rubinho.itsec_lab1.exceptions.UserAlreadyExistsException;
import com.rubinho.itsec_lab1.model.Account;
import com.rubinho.itsec_lab1.repository.AccountRepository;
import com.rubinho.itsec_lab1.security.UserAuthProvider;
import com.rubinho.itsec_lab1.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;

@Service
public class AuthServiceImpl implements AuthService {
    private final AccountRepository accountRepository;
    private final UserAuthProvider userAuthProvider;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(AccountRepository accountRepository,
                           UserAuthProvider userAuthProvider,
                           PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.userAuthProvider = userAuthProvider;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String register(Account account) {
        final String login = account.getLogin();
        if (accountRepository.existsByLogin(login)) {
            throw new UserAlreadyExistsException(login);
        }
        accountRepository.save(account);
        return userAuthProvider.createToken(login);
    }

    @Override
    public String login(String login, String password) {
        final Account account = accountRepository.findByLogin(login)
                .orElseThrow(() -> new UnauthorizedException("Аккаунт %s не найден".formatted(login)));
        if (passwordEncoder.matches(CharBuffer.wrap(password), account.getPassword())) {
            return userAuthProvider.createToken(login);
        }
        throw new UnauthorizedException("Неправильный пароль для пользователя %s".formatted(login));
    }
}
