package com.rubinho.itsec_lab1.rest;

import com.rubinho.itsec_lab1.dto.request.FlatRequestDto;
import com.rubinho.itsec_lab1.dto.response.FlatResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/data")
public interface FlatsApi {
    @GetMapping
    @PreAuthorize("isAuthenticated()")
    ResponseEntity<List<FlatResponseDto>> getFlats();

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    ResponseEntity<FlatResponseDto> createFlat(@RequestBody @Valid FlatRequestDto flatRequestDto);
}
