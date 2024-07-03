package com.campusland.entities.Movie.infrastructure;

import java.util.List;
import java.util.Optional;

import com.campusland.entities.Movie.domain.Movie;

public interface MovieRepository {
    void addMovie(Movie movie);
    void updateMovie(Movie movie);
    void deleteMovie(int id);
    Optional<Movie> findById(int id);
    List<Movie> findAll(); 
}
