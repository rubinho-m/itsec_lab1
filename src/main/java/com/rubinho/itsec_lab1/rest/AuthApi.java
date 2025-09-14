package com.rubinho.itsec_lab1.rest;

import com.rubinho.itsec_lab1.dto.request.AccountRequestDto;
import com.rubinho.itsec_lab1.dto.response.AccountResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/auth")
public interface AuthApi {
    @PostMapping(value = "/register")
    ResponseEntity<AccountResponseDto> register(@RequestBody @Valid AccountRequestDto accountRequestDto);

    @PostMapping(value = "/login")
    ResponseEntity<AccountResponseDto> authorize(@RequestBody @Valid AccountRequestDto accountRequestDto);
}
