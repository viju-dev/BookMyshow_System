package com.example.BookMyShow_System.EntryDTOs;

import com.example.BookMyShow_System.Enums.LanguagesEnum;
import com.example.BookMyShow_System.Enums.MovieGenreEnum;
import com.example.BookMyShow_System.Enums.RatingEnum;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data

public class MovieEntryDTO {

    private String movieName;
    private RatingEnum rating;
    private MovieGenreEnum[] genre;
    private int duration;
//    private List<LanguagesEnum> languages;
//    private LanguagesEnum languages;
    @Enumerated(value = EnumType.STRING)
        private LanguagesEnum[] languages; // to get correct multiple languages used in entryDto
//    private List<String> languages;
    //LanguagesEnum
}
