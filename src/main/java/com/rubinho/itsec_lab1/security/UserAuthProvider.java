package com.rubinho.itsec_lab1.security;

import org.springframework.security.core.Authentication;

public interface UserAuthProvider {
    String createToken(String login);

    Authentication validateToken(String token);
}
