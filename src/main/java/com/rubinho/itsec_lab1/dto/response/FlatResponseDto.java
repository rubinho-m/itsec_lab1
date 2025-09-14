package com.rubinho.itsec_lab1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class FlatResponseDto {
    private Long id;

    private String address;

    private Float squareMeters;

    private Integer cost;

    private Float costPerSquareMeters;
}
