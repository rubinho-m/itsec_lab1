package com.rubinho.itsec_lab1.services;

import com.rubinho.itsec_lab1.model.Flat;

import java.util.List;

public interface FlatService {
    Flat createFlat(Flat flat);

    List<Flat> getFlats();
}
