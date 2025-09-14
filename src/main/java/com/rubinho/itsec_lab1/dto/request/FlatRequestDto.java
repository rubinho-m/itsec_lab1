package com.rubinho.itsec_lab1.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class FlatRequestDto {
    @NotBlank
    private String address;

    @Positive
    @NotNull
    private Float squareMeters;

    @Positive
    @NotNull
    private Integer cost;
}
