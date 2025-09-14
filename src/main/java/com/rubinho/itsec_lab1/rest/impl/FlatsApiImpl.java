package com.rubinho.itsec_lab1.rest.impl;

import com.rubinho.itsec_lab1.dto.request.FlatRequestDto;
import com.rubinho.itsec_lab1.dto.response.FlatResponseDto;
import com.rubinho.itsec_lab1.mapper.FlatMapper;
import com.rubinho.itsec_lab1.rest.FlatsApi;
import com.rubinho.itsec_lab1.services.FlatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FlatsApiImpl implements FlatsApi {
    private final FlatService flatService;
    private final FlatMapper flatMapper;

    @Autowired
    public FlatsApiImpl(FlatService flatService,
                        FlatMapper flatMapper) {
        this.flatService = flatService;
        this.flatMapper = flatMapper;
    }

    @Override
    public ResponseEntity<List<FlatResponseDto>> getFlats() {
        return ResponseEntity.ok(
                flatService.getFlats()
                        .stream()
                        .map(flatMapper::toDto)
                        .toList()
        );
    }

    @Override
    public ResponseEntity<FlatResponseDto> createFlat(FlatRequestDto flatRequestDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        flatMapper.toDto(
                                flatService.createFlat(
                                        flatMapper.toEntity(flatRequestDto)
                                )
                        )
                );
    }
}
