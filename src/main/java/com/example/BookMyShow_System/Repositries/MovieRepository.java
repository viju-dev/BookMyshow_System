package com.example.BookMyShow_System.Repositries;

import com.example.BookMyShow_System.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Integer> {

    Movie findByMovieName(String name);

    List<Movie> findByLanguages(String languages);


    void deleteByMovieName(String name);

//    Movie findByName(String name);
}
