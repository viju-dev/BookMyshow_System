package com.example.BookMyShow_System.Repositries;

import com.example.BookMyShow_System.Enums.LocationEnum;
import com.example.BookMyShow_System.Models.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface TheatreRepository extends JpaRepository<Theatre,Integer> {
    boolean existsByNameAndLocation(String name, String location);


    Theatre findByNameAndLocation(String theatreName, String location);

    Theatre[] findByLocation(String location);
}
