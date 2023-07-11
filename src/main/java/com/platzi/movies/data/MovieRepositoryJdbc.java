package com.platzi.movies.data;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.platzi.movies.model.Genre;
import com.platzi.movies.model.Movie;

public class MovieRepositoryJdbc implements MovieRepository {

    JdbcTemplate jdbcTemplate;

    public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {

        Object[] args = { id };

        return jdbcTemplate.queryForObject("select * from Movies where id = ?", args, movieMapper);
    }

    @Override
    public Collection<Movie> findAll() {
        return jdbcTemplate.query("select * from movies", movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {
        jdbcTemplate.update("insert into movies (name, minutes, genre) values (?, ?, ?)", movie.getName(),
                movie.getMinutes(), movie.getGenre().toString());
    }

    @Override
    public Collection<Movie> findByName(String name) {
        Collection<Movie> allMovies = findAll();

        return allMovies.stream().filter(movie -> movie.getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors
        .toList());
    }

    private static RowMapper<Movie> movieMapper = (rs, rowNum) -> new Movie(rs.getInt("id"), rs.getString("name"),
            rs.getInt("minutes"),
            Genre.valueOf(rs.getString("genre")));

}