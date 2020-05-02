package org.example.repository.impl;

import org.example.model.MovieRequestStatus;
import org.example.repository.AbstractRepository;

public class MovieRequestStatusRepository extends AbstractRepository<MovieRequestStatus,
        Integer> {
    @Override
    protected Class<MovieRequestStatus> getPersistentClass() {
        return MovieRequestStatus.class;
    }
}
