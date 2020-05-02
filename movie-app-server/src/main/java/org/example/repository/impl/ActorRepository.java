package org.example.repository.impl;

import org.example.api.model.Actor;
import org.example.repository.AbstractRepository;

public class ActorRepository extends AbstractRepository<Actor, Integer> {
    @Override
    protected Class<Actor> getPersistentClass() {
        return Actor.class;
    }
}