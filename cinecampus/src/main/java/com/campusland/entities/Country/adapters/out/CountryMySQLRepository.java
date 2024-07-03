package com.campusland.entities.Country.adapters.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.campusland.entities.Country.domain.Country;
import com.campusland.entities.Country.infrastructure.CountryRepository;

public class CountryMySQLRepository {
    String url = "";
    String user = "";
    String password = "";


    public void addCountry(Country Country) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO pais (id, descripcion) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, Country.getId());
                statement.setString(2, Country.getDescription());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCountry(Country Country) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE TABLE pais SET descripcion = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, Country.getDescription());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCountry(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE pais WHERE id = ?";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setInt(1, id);
                    statement.executeUpdate();
                }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<Country> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT descripcion FROM pais WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Country Country = new Country(
                            resultSet.getInt("id"),
                            resultSet.getString("descripcion")
                        );
                        return Optional.of(Country);

                    }
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public List<Country> findAll() {
        List<Country> actores = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id, descripcion FROM pais";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Country Country = new Country(
                            resultSet.getInt("id"),
                            resultSet.getString("descripcion")
                        );
                        actores.add(Country);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actores;
    }

    
}
