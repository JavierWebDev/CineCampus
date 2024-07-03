package com.campusland.entities.Gender.application;

import java.util.List;
import java.util.Optional;

import com.campusland.entities.Gender.domain.Gender;
import com.campusland.entities.Gender.infrastructure.GenderRepository;

public class GenderService {
    private final GenderRepository genderRepository;

    public GenderService(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    public void createGender(Gender gender) {
        genderRepository.addGender(gender);
    }

    public void updateGender(Gender gender) {
        genderRepository.updateGender(gender);
    }

    public void deleteGender(int id) {
        genderRepository.deleteGender(id);
    }

    public Optional<Gender> findGenderById(int id) {
        return genderRepository.findById(id);
    }

    public List<Gender> getAllGenders() {
        return genderRepository.findAll();
    }
}
