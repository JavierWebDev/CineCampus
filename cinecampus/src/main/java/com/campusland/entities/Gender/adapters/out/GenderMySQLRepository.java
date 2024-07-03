package com.campusland.entities.Gender.adapters.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.campusland.entities.Gender.domain.Gender;
import com.campusland.entities.Gender.domain.Gender;
import com.campusland.entities.Gender.infrastructure.GenderRepository;

public class GenderMySQLRepository implements GenderRepository{
    private String url;
    private String user;
    private String password;


    public GenderMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public void addGender(Gender gender) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO gender (id, nombre, idnacionalidad, edad, idgenero) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, gender.getId());
                statement.setString(2, gender.getDescripcion());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateGender(Gender gender) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE TABLE gender SET descripcion = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(2, gender.getDescripcion());
                statement.setInt(5, gender.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteGender(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE Gender WHERE id = ?";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setInt(1, id);
                    statement.executeUpdate();
                }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<Gender> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT descripcion FROM Gender WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Gender gender = new Gender(
                            resultSet.getInt("id"),
                            resultSet.getString("descripcion")
                        );
                        return Optional.of(gender);

                    }
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public List<Gender> findAll() {
        List<Gender> genders = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT nombre, idnacionalidad, edad, idgenero FROM Gender";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Gender gender = new Gender(
                            resultSet.getInt("id"),
                            resultSet.getString("descripcion")
                        );
                        genders.add(gender);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genders;
    }

}
