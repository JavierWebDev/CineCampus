package com.campusland.entities.Country.infrastructure;

import java.util.List;
import java.util.Optional;

import com.campusland.entities.Country.domain.Country;

public interface CountryRepository {
    void addCountry(Country Country);
    void updateCountry(Country Country);
    void deleteCountry(int id);
    Optional<Country> findById(int id);
    List<Country> findAll(); 
}
