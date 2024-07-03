package com.campusland.entities.ActorType.application;
import java.util.List;
import java.util.Optional;

import com.campusland.entities.ActorType.domain.ActorType;
import com.campusland.entities.ActorType.infrastructure.ActorTypeRepository;

public class ActorTypeService {
    private final ActorTypeRepository actorTypeRepository;

    public ActorTypeService(ActorTypeRepository actorTypeRepository) {
        this.actorTypeRepository = actorTypeRepository;
    }

    public void createActorType(ActorType actorType) {
        actorTypeRepository.addActorType(actorType);
    }

    public void updateActorType(ActorType actorType) {
        actorTypeRepository.updateActorType(actorType);
    }

    public void deleteActorType(int id) {
        actorTypeRepository.deleteActorType(id);
    }

    public Optional<ActorType> findActorById(int id) {
        return actorTypeRepository.findById(id);
    }

    public List<ActorType> getAllActorTypes() {
        return actorTypeRepository.findAll();
    }
}
