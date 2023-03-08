package com.example.BookMyShow_System.Dummy;

import com.example.BookMyShow_System.Enums.LanguagesEnum;
import com.example.BookMyShow_System.Enums.MovieGenreEnum;
import com.example.BookMyShow_System.Enums.RatingEnum;
import com.example.BookMyShow_System.Models.Show;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


//@Builder // it requires both NoArg and AllArg Constructors
//@Data  //its combines @Getter, @Setter, @RequiredArgsConstructor
//@NoArgsConstructor
//@AllArgsConstructor

public class DummyMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true,nullable = false)

    private String movieName;

    @Enumerated(EnumType.STRING)
    private RatingEnum rating; // ask sir how can we implement int in enum // or we can just give double with limit using exception or this will get take care at frontb end
    //private double ratings;

    //private LocalTime duration ; // we'll require custom getter and setter; // we can set this attr to simple int

    //private String description;

    private int duration;

    @Enumerated(EnumType.STRING)
    private MovieGenreEnum genre;

    @Enumerated(EnumType.STRING)
    private LanguagesEnum languages;
// private List<LanguagesEnum> languages = new ArrayList<LanguagesEnum>();//Unable to build Hibernate SessionFactory; nested exception is org.hibernate.MappingException: Could not determine type for: java.util.List, at table: movie, for columns: [org.hibernate.mapping.Column(languages)]
//    private List<LanguagesEnum> languages = new ArrayList<LanguagesEnum>(Arrays.asList(LanguagesEnum.values()));
    //error : was annotated as enumerated, but its java type is not an enum [java.util.List]

    //Mapping Movie -> Order
//    @OneToOne(mappedBy = "movie",cascade = CascadeType.ALL)
//    private Order order; // ig this is not require

    //Mapping Movie -> Ticket //OneToMany optional
//    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
//    private List<Ticket> ticketList = new ArrayList<>();

    //Mapping Movie -> Show (it means show of morning , or evening 4 , or night)
    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL) // cascade type all ???
    private List<Show> showList = new ArrayList<>();


}
