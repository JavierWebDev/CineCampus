package com.campusland.entities.Movie.application;

import java.util.List;
import java.util.Optional;

import com.campusland.entities.Movie.domain.Movie;
import com.campusland.entities.Movie.infrastructure.MovieRepository;

public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void createMovie(Movie movie) {
        movieRepository.addMovie(movie);
    }

    public void updateMovie(Movie movie) {
        movieRepository.updateMovie(movie);
    }

    public void deleteMovie(int id) {
        movieRepository.deleteMovie(id);
    }

    public Optional<Movie> findMovieById(int id) {
        return movieRepository.findById(id);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}
