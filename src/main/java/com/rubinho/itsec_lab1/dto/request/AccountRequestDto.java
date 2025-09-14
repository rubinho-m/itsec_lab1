package com.rubinho.itsec_lab1.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class AccountRequestDto {
    @NotBlank
    private String login;

    @NotBlank
    private String password;
}
