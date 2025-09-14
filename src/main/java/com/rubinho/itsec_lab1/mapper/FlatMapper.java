package com.rubinho.itsec_lab1.mapper;

import com.rubinho.itsec_lab1.dto.request.FlatRequestDto;
import com.rubinho.itsec_lab1.dto.response.FlatResponseDto;
import com.rubinho.itsec_lab1.model.Flat;

public interface FlatMapper {
    Flat toEntity(FlatRequestDto flatRequestDto);

    FlatResponseDto toDto(Flat flat);
}
