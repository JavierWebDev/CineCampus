package com.campusland.entities.ActorType.application;
import java.util.List;
import java.util.Optional;

import com.campusland.entities.ActorType.domain.ActorType;
import com.campusland.entities.ActorType.infrastructure.ActorTypeRepository;

public class ActorService {
    
    private final ActorTypeRepository actorTypeRepository;

    public ActorService(ActorTypeRepository actorTypeRepository) {
        this.actorTypeRepository = actorTypeRepository;
    }

    public void createActorType(ActorType actorType) {
        actorTypeRepository.addActorType(actorType);
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
