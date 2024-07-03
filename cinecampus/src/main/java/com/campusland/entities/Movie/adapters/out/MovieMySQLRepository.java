package com.campusland.entities.Movie.adapters.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.campusland.entities.Movie.domain.Movie;
import com.campusland.entities.Movie.infrastructure.MovieRepository;

public class MovieMySQLRepository implements MovieRepository {
    String url;
    String user;
    String password;

    public MovieMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public void addMovie(Movie movie) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO pelicula (id, codinterno, nombre, duracion, sinopsis) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, movie.getCodinterno());
                statement.setString(2, movie.getNombre());
                statement.setString(3, movie.getDuracion());
                statement.setString(4, movie.getSinopsis());
                statement.setInt(5, movie.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMovie(Movie movie) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE pelicula SET codinterno = ?, nombre = ?, duracion = ?, sinopsis = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, movie.getCodinterno());
                statement.setString(2, movie.getNombre());
                statement.setString(3, movie.getDuracion());
                statement.setString(4, movie.getSinopsis());
                statement.setInt(5, movie.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMovie(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM pelicula WHERE id = ?";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setInt(1, id);
                    statement.executeUpdate();
                }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<Movie> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT codinterno, nombre, duracion, sinopsis FROM pelicula WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Movie movie = new Movie(
                            resultSet.getInt("id"),
                            resultSet.getString("codinterno"),
                            resultSet.getString("nombre"),
                            resultSet.getString("duracion"),
                            resultSet.getString("sinopsis")
                        );
                        return Optional.of(movie);

                    }
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public List<Movie> findAll() {
        List<Movie> movies = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id, codinterno, nombre, duracion, sinopsis FROM pelicula";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Movie movie = new Movie(
                            resultSet.getInt("id"),
                            resultSet.getString("codinterno"),
                            resultSet.getString("nombre"),
                            resultSet.getString("duracion"),
                            resultSet.getString("sinopsis")
                        );
                        movies.add(movie);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }
    
}
