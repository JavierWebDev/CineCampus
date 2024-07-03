package com.campusland.entities.Country.application;
import java.util.List;
import java.util.Optional;

import com.campusland.entities.Country.domain.Country;
import com.campusland.entities.Country.infrastructure.CountryRepository;

public class CountryService {
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public void createCountry(Country country) {
        countryRepository.addCountry(country);
    }

    public void updateCountry(Country country) {
        countryRepository.updateCountry(country);
    }

    public void deleteCountry(int id) {
        countryRepository.deleteCountry(id);
    }

    public Optional<Country> findCountryById(int id) {
        return countryRepository.findById(id);
    }

    public List<Country> getAllCountrys() {
        return countryRepository.findAll();
    }
}
