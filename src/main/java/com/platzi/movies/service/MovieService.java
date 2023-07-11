package com.platzi.movies.service;

import java.util.Collection;
import java.util.stream.Collectors;

import com.platzi.movies.data.MovieRepository;
import com.platzi.movies.model.Genre;
import com.platzi.movies.model.Movie;

public class MovieService {

    MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGenre(Genre genre) {
        return movieRepository.findAll().stream().filter(movie -> movie.getGenre() == genre)
                .collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByDuration(int duration) {
        return movieRepository.findAll().stream().filter(movie -> movie.getMinutes() <= duration)
                .collect(Collectors.toList());
    }

}
