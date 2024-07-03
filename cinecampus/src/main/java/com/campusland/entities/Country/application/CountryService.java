package com.campusland.entities.Country.application;
import java.util.List;
import java.util.Optional;

import com.campusland.entities.Country.domain.Country;
import com.campusland.entities.Country.infrastructure.CountryRepository;

public class CountryService {
    private final CountryRepository CountryRepository;

    public CountryService(CountryRepository CountryRepository) {
        this.CountryRepository = CountryRepository;
    }

    public void createCountry(Country Country) {
        CountryRepository.addCountry(Country);
    }

    public void updateCountry(Country Country) {
        CountryRepository.updateCountry(Country);
    }

    public void deleteCountry(int id) {
        CountryRepository.deleteCountry(id);
    }

    public Optional<Country> findCountryById(int id) {
        return CountryRepository.findById(id);
    }

    public List<Country> getAllCountrys() {
        return CountryRepository.findAll();
    }
}
