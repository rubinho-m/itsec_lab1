package com.rubinho.itsec_lab1.mapper.impl;

import com.rubinho.itsec_lab1.dto.request.FlatRequestDto;
import com.rubinho.itsec_lab1.dto.response.FlatResponseDto;
import com.rubinho.itsec_lab1.mapper.FlatMapper;
import com.rubinho.itsec_lab1.model.Flat;
import org.springframework.stereotype.Component;
import org.springframework.web.util.HtmlUtils;

@Component
public class FlatMapperImpl implements FlatMapper {
    @Override
    public Flat toEntity(FlatRequestDto flatRequestDto) {
        return Flat.builder()
                .address(HtmlUtils.htmlEscape(flatRequestDto.getAddress()))
                .cost(flatRequestDto.getCost())
                .squareMeters(flatRequestDto.getSquareMeters())
                .build();
    }

    @Override
    public FlatResponseDto toDto(Flat flat) {
        return FlatResponseDto.builder()
                .id(flat.getId())
                .address(flat.getAddress())
                .cost(flat.getCost())
                .squareMeters(flat.getSquareMeters())
                .costPerSquareMeters(flat.getCost() / flat.getSquareMeters())
                .build();
    }
}
