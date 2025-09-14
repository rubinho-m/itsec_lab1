package com.rubinho.itsec_lab1.mapper.impl;

import com.rubinho.itsec_lab1.dto.request.AccountRequestDto;
import com.rubinho.itsec_lab1.dto.response.AccountResponseDto;
import com.rubinho.itsec_lab1.mapper.AuthMapper;
import com.rubinho.itsec_lab1.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.nio.CharBuffer;

@Component
public class AuthMapperImpl implements AuthMapper {
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthMapperImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Account toEntity(AccountRequestDto accountRequestDto) {
        return Account.builder()
                .login(accountRequestDto.getLogin())
                .password(passwordEncoder.encode(CharBuffer.wrap(accountRequestDto.getPassword())))
                .build();
    }

    @Override
    public AccountResponseDto toDto(String token) {
        return AccountResponseDto.builder()
                .token(token)
                .build();
    }
}
