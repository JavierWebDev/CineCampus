package com.campusland.entities.Format.adapters.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.campusland.entities.Format.domain.Format;
import com.campusland.entities.Format.infrastructure.FormatRepository;
public class FormatMySQLRepository {
    String url = "";
    String user = "";
    String password = "";


    public void addFormat(Format Format) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO formato (id, descripcion) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, Format.getId());
                statement.setString(2, Format.getDescription());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateFormat(Format Format) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE TABLE formato SET descripcion = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, Format.getDescription());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFormat(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE formato WHERE id = ?";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setInt(1, id);
                    statement.executeUpdate();
                }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<Format> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT descripcion FROM formato WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Format Format = new Format(
                            resultSet.getInt("id"),
                            resultSet.getString("descripcion")
                        );
                        return Optional.of(Format);

                    }
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public List<Format> findAll() {
        List<Format> actores = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id, descripcion FROM formato";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Format Format = new Format(
                            resultSet.getInt("id"),
                            resultSet.getString("descripcion")
                        );
                        actores.add(Format);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actores;
    }

}
