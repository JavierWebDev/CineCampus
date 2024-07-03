package com.campusland.entities.Gender.infrastructure;

import java.util.List;
import java.util.Optional;

import com.campusland.entities.Gender.domain.Gender;

public interface GenderRepository {
    void addGender(Gender gender);
    void updateGender(Gender gender);
    void deleteGender(int id);
    Optional<Gender> findById(int id);
    List<Gender> findAll(); 
}
