package com.campusland.entities.ActorType.infrastructure;

import java.util.List;
import java.util.Optional;

import com.campusland.entities.ActorType.domain.ActorType;

public interface ActorTypeRepository {
    void addActor(ActorType actorType);
    void updateActor(ActorType actorType);
    void deleteActorType(int id);
    Optional<ActorType> findById(int id);
    List<ActorType> findAll(); 
}
