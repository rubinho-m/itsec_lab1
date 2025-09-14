package com.rubinho.itsec_lab1.services.impl;

import com.rubinho.itsec_lab1.model.Flat;
import com.rubinho.itsec_lab1.repository.FlatRepository;
import com.rubinho.itsec_lab1.services.FlatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlatServiceImpl implements FlatService {
    private final FlatRepository flatRepository;

    @Autowired
    public FlatServiceImpl(FlatRepository flatRepository) {
        this.flatRepository = flatRepository;
    }

    @Override
    public Flat createFlat(Flat flat) {
        return flatRepository.save(flat);
    }

    @Override
    public List<Flat> getFlats() {
        return flatRepository.findAll();
    }
}
