package com.example.BookMyShow_System.Models;

import com.example.BookMyShow_System.Enums.LanguagesEnum;
import com.example.BookMyShow_System.Enums.MovieGenreEnum;
import com.example.BookMyShow_System.Enums.RatingEnum;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Builder // it requires both NoArg and AllArg Constructors
@Data  //its combines @Getter, @Setter, @RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor

public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true,nullable = false)
    private String movieName;

    @Enumerated(EnumType.STRING)
    private RatingEnum rating;

    private int duration;

    private String genre;

//    @Enumerated(EnumType.STRING) // ued to get enum value as string another one to get index of that value in integer
    //private LanguagesEnum languages;
    private String languages; // used languages coz we cant store enumarray or other array in database
//    private LanguagesEnum[] languages  ={LanguagesEnum.HINDI,LanguagesEnum.ENGLISH};


    //Mapping Movie -> Show (it means show of morning , or evening 4 , or night)
    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
    private List<Show> showList = new ArrayList<>();


}
