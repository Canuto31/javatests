package com.platzi.movies.data;

import java.util.Collection;

import com.platzi.movies.model.Movie;

public interface MovieRepository {
    
    Movie findById(long id);
    Collection<Movie> findAll();
    void saveOrUpdate(Movie movie);
    Collection<Movie> findByName(String name);
}
