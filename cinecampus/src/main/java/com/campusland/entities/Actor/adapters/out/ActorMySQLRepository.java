package com.campusland.entities.Actor.adapters.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.campusland.entities.Actor.domain.Actor;
import com.campusland.entities.Actor.infrastructure.ActorRepository;

public class ActorMySQLRepository implements ActorRepository{
    private String url;
    private String user;
    private String password;


    public ActorMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public void addActor(Actor actor) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO actor (id, nombre, idnacionalidad, edad, idgenero) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, actor.getId());
                statement.setString(2, actor.getNombre());
                statement.setInt(3, actor.getIdNacionalidad());
                statement.setInt(4, actor.getEdad());
                statement.setInt(5, actor.getIdGenero());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateActor(Actor actor) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE actor SET nombre = ?, idnacionalidad = ?, edad = ?, idgenero = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, actor.getNombre());
                statement.setInt(2, actor.getIdNacionalidad());
                statement.setInt(3, actor.getEdad());
                statement.setInt(4, actor.getIdGenero());
                statement.setInt(5, actor.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteActor(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM actor WHERE id = ?";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setInt(1, id);
                    statement.executeUpdate();
                }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<Actor> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id, nombre, idnacionalidad, edad, idgenero FROM actor WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Actor actor = new Actor(
                            resultSet.getInt("id"),
                            resultSet.getString("nombre"),
                            resultSet.getInt("idnacionalidad"),
                            resultSet.getInt("edad"),
                            resultSet.getInt("idgenero")
                        );
                        return Optional.of(actor);

                    }
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public List<Actor> findAll() {
        List<Actor> actores = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id, nombre, idnacionalidad, edad, idgenero FROM actor";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Actor actor = new Actor(
                            resultSet.getInt("id"),
                            resultSet.getString("nombre"),
                            resultSet.getInt("idnacionalidad"),
                            resultSet.getInt("edad"),
                            resultSet.getInt("idgenero")
                        );
                        actores.add(actor);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actores;
    }
}
