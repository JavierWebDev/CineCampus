package com.campusland.entities.ActorType.adapters.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.campusland.entities.ActorType.domain.ActorType;

public class ActorTypeMySQLRepository {
    String url;
    String user;
    String password;


    public ActorTypeMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public void addActorType(ActorType actorType) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO tipoactor (id, descripcion) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, actorType.getId());
                statement.setString(2, actorType.getDescription());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateActorType(ActorType actorType) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE TABLE tipoactor SET descripcion = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, actorType.getDescription());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteActorType(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE tipoactor WHERE id = ?";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setInt(1, id);
                    statement.executeUpdate();
                }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<ActorType> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT descripcion FROM tipoactor WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        ActorType actorType = new ActorType(
                            resultSet.getInt("id"),
                            resultSet.getString("descripcion")
                        );
                        return Optional.of(actorType);

                    }
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public List<ActorType> findAll() {
        List<ActorType> actores = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id, descripcion FROM tipoactor";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        ActorType actorType = new ActorType(
                            resultSet.getInt("id"),
                            resultSet.getString("descripcion")
                        );
                        actores.add(actorType);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actores;
    }

    
}
