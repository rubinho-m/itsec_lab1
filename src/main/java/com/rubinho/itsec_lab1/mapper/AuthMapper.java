package com.rubinho.itsec_lab1.mapper;

import com.rubinho.itsec_lab1.dto.request.AccountRequestDto;
import com.rubinho.itsec_lab1.dto.response.AccountResponseDto;
import com.rubinho.itsec_lab1.model.Account;

public interface AuthMapper {
    Account toEntity(AccountRequestDto accountRequestDto);

    AccountResponseDto toDto(String token);
}
