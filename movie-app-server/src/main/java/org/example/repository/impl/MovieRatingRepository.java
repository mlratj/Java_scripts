package org.example.repository.impl;

import org.example.model.MovieRating;
import org.example.repository.AbstractRepository;

public class MovieRatingRepository extends AbstractRepository<MovieRating, Integer> {
    @Override
    protected Class<MovieRating> getPersistentClass() {
        return MovieRating.class;
    }
}
