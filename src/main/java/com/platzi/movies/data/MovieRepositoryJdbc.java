package com.platzi.movies.data;

import java.util.Collection;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Collection<Movie> findAll() {
        return jdbcTemplate.query("select * from movies", movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveOrUpdate'");
    }

    private static RowMapper<Movie> movieMapper = (rs, rowNum) -> new Movie(rs.getInt("id"), rs.getString("name"), rs.getInt("minutes"),
            Genre.valueOf(rs.getString("genre")));

}