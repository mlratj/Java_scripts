package org.example.repository.impl;

import org.example.model.MovieFavourite;
import org.example.repository.AbstractRepository;

public class MovieFavouriteRepository extends AbstractRepository<MovieFavourite, Boolean> {
    @Override
    protected Class<MovieFavourite> getPersistentClass() {
        return MovieFavourite.class;
    }
}
