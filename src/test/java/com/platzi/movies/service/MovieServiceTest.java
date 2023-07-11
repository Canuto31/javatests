package com.platzi.movies.service;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.platzi.movies.data.MovieRepository;
import com.platzi.movies.model.Genre;
import com.platzi.movies.model.Movie;

public class MovieServiceTest {

    MovieService movieService;

    @Before
    public void setUp() {
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);

        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, Genre.ACTION),
                        new Movie(2, "Memento", 113, Genre.THRILLER),
                        new Movie(3, "There's Something About Mary", 119, Genre.COMEDY),
                        new Movie(4, "Super 8", 112, Genre.THRILLER),
                        new Movie(5, "Scream", 111, Genre.HORROR),
                        new Movie(6, "Home Alone", 103, Genre.COMEDY),
                        new Movie(7, "Matrix", 136, Genre.ACTION)));

        movieService = new MovieService(movieRepository);
    }

    @Test
    public void return_movies_by_genre() {

        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);

        assertThat(getMovieIds(movies), is(Arrays.asList(3, 6)));
    }

    @Test
    public void return_movies_by_duration() {

        Collection<Movie> movies = movieService.findMoviesByDuration(119);

        assertThat(getMovieIds(movies), is(Arrays.asList(2, 3, 4, 5, 6)));
    }

    private List<Integer> getMovieIds(Collection<Movie> movies) {
        List<Integer> movieIds = movies.stream().map(movie -> movie.getId()).collect(Collectors.toList());
        return movieIds;
    }

}
