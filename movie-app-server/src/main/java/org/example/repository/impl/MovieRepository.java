package org.example.repository.impl;

import org.example.api.model.Movie;
import org.example.repository.AbstractRepository;

public class MovieRepository extends AbstractRepository<Movie, Integer> {
    @Override
    protected Class<Movie> getPersistentClass() {
        return Movie.class;
    }
}
