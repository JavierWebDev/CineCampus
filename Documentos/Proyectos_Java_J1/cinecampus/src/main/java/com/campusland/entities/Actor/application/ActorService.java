package com.campusland.entities.Actor.application;

import java.util.List;
import java.util.Optional;

import com.campusland.entities.Actor.domain.Actor;
import com.campusland.entities.Actor.infrastructure.ActorRepository;

public class ActorService {
    private final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public void createActor(Actor actor) {
        actorRepository.addActor(actor);
    }

    public void updateActor(Actor actor) {
        actorRepository.updateActor(actor);
    }

    public void deleteActor(int id) {
        actorRepository.deleteActor(id);
    }

    public Optional<Actor> findActorById(int id) {
        return actorRepository.findById(id);
    }

    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }
}
