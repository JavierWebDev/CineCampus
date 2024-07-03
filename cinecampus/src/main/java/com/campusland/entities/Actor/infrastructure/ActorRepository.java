package com.campusland.entities.Actor.infrastructure;

import java.util.List;
import java.util.Optional;

import com.campusland.entities.Actor.domain.Actor;

public interface ActorRepository {
    void addActor(Actor actor);
    void updateActor(Actor actor);
    void deleteActor(int id);
    Optional<Actor> findById(int id);
    List<Actor> findAll(); 
}
