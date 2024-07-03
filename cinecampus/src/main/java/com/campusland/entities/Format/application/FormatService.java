package com.campusland.entities.Format.application;
import java.util.List;
import java.util.Optional;

import com.campusland.entities.Format.domain.Format;
import com.campusland.entities.Format.infrastructure.FormatRepository;
public class FormatService {
    private final FormatRepository FormatRepository;

    public FormatService(FormatRepository FormatRepository) {
        this.FormatRepository = FormatRepository;
    }

    public void createFormat(Format Format) {
        FormatRepository.addFormat(Format);
    }

    public void updateFormat(Format Format) {
        FormatRepository.updateFormat(Format);
    }

    public void deleteFormat(int id) {
        FormatRepository.deleteFormat(id);
    }

    public Optional<Format> findFormatById(int id) {
        return FormatRepository.findById(id);
    }

    public List<Format> getAllFormats() {
        return FormatRepository.findAll();
    }
}
