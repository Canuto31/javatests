package com.platzi.movies.data;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptException;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import com.platzi.movies.model.Genre;
import com.platzi.movies.model.Movie;

public class MovieRepositoryJdbcTest {

    @Test
    public void load_all_movies() throws ScriptException, SQLException {

        DataSource dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");

        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("test-data.sql", getClass()));

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        MovieRepositoryJdbc movieRepository = new MovieRepositoryJdbc(jdbcTemplate);

        Collection<Movie> movies = movieRepository.findAll();

        assertThat(movies, is(Arrays.asList(new Movie(1, "Dark Knight", 152, Genre.ACTION),
                new Movie(2, "Memento", 113, Genre.THRILLER),
                new Movie(3, "Matrix", 136, Genre.ACTION))));
    }

}
