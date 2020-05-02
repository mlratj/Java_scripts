package org.example.repository.impl;

import org.example.model.Director;
import org.example.repository.AbstractRepository;

public class DirectorRepository extends AbstractRepository<Director, Integer> {
    @Override
    protected Class<Director> getPersistentClass() {
        return Director.class;
    }
}