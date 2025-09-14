package com.rubinho.itsec_lab1.services;

import com.rubinho.itsec_lab1.model.Account;

public interface AuthService {
    String register(Account account);

    String login(String login, String password);
}
