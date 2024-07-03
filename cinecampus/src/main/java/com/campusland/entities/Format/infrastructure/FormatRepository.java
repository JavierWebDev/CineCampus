package com.campusland.entities.Format.infrastructure;
import java.util.List;
import java.util.Optional;

import com.campusland.entities.Format.domain.Format;
public interface FormatRepository {
    void addFormat(Format Format);
    void updateFormat(Format Format);
    void deleteFormat(int id);
    Optional<Format> findById(int id);
    List<Format> findAll(); 
}
