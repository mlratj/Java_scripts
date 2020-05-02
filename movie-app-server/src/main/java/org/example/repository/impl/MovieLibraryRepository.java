package org.example.repository.impl;

import org.example.model.MovieLibrary;
import org.example.repository.AbstractRepository;

public class MovieLibraryRepository extends AbstractRepository<MovieLibrary, Integer> {
    @Override
    protected Class<MovieLibrary> getPersistentClass() {
        return MovieLibrary.class;
    }
}