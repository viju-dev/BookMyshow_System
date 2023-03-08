package com.example.BookMyShow_System.ResponseDTOs;

import com.example.BookMyShow_System.Enums.LanguagesEnum;
import com.example.BookMyShow_System.Enums.MovieGenreEnum;
import com.example.BookMyShow_System.Enums.RatingEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponseDTO {
    private String movieName;
    private RatingEnum rating;
    private MovieGenreEnum[] genre; // can be changed to string as we are just showing it to user
    private int duration;
    private LanguagesEnum[] languages;
}
