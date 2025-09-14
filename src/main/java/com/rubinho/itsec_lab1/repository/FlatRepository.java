package com.rubinho.itsec_lab1.repository;

import com.rubinho.itsec_lab1.model.Flat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlatRepository extends JpaRepository<Flat, Long> {
}
