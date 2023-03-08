package com.example.BookMyShow_System.Dummy;

import com.example.BookMyShow_System.Models.Show;
import com.example.BookMyShow_System.Models.TheatreSeat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Entity
//@Table(name="Theatre")
//@Builder
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class DummyTheatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
//    private String description;
    private String address; //can set diffrent attr for location so that they can get filter using location
//    private RatingEnum rating;

//    @Enumerated(EnumType.STRING)
//    private FacilitiesEnum facilities; // optional Attribute // ask sir how can we use Enum as data type without enum class

    //screen TYpe  //we can use enum // or vitual obj as dto ?

    //Mapping Theatre -> Show
    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    private List<Show> showList = new ArrayList<>();

    //Mapping Theatre -> TheatreSeat
    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    private List<TheatreSeat> theatreSeatList = new ArrayList<>();

    //Mapping Theatre -> Ticket
//    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
//    private List<Ticket> ticketList = new ArrayList<>();
    //offcourse neccesaay coz ticket will have Theatre data // but is both sided mapping necessary for this ?? we can have omly that one


}
