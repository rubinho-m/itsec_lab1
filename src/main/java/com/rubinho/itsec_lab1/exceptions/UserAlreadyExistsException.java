package com.rubinho.itsec_lab1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserAlreadyExistsException extends ResponseStatusException {
    public UserAlreadyExistsException(String login) {
        super(HttpStatus.BAD_REQUEST, "Пользователь %s уже существует".formatted(login));
    }
}
