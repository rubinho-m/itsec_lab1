package com.rubinho.itsec_lab1.rest.impl;

import com.rubinho.itsec_lab1.dto.request.AccountRequestDto;
import com.rubinho.itsec_lab1.dto.response.AccountResponseDto;
import com.rubinho.itsec_lab1.mapper.AuthMapper;
import com.rubinho.itsec_lab1.rest.AuthApi;
import com.rubinho.itsec_lab1.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthApiImpl implements AuthApi {
    private final AuthService authService;
    private final AuthMapper authMapper;

    @Autowired
    public AuthApiImpl(AuthService authService, AuthMapper authMapper) {
        this.authService = authService;
        this.authMapper = authMapper;
    }

    @Override
    public ResponseEntity<AccountResponseDto> register(AccountRequestDto accountRequestDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        authMapper.toDto(
                                authService.register(
                                        authMapper.toEntity(accountRequestDto)
                                )
                        )
                );
    }

    @Override
    public ResponseEntity<AccountResponseDto> authorize(AccountRequestDto accountRequestDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        authMapper.toDto(
                                authService.login(
                                        accountRequestDto.getLogin(), accountRequestDto.getPassword()
                                )
                        )
                );
    }
}
