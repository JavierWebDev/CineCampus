package com.campusland.entities.ActorType.infrastructure;

import java.util.List;
import java.util.Optional;

import com.campusland.entities.ActorType.domain.ActorType;

public interface ActorTypeRepository {
    void addActorType(ActorType actorType);
    void updateActorType(ActorType actorType);
    void deleteActorType(int id);
    Optional<ActorType> findById(int id);
    List<ActorType> findAll(); 
}
