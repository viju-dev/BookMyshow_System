package com.example.BookMyShow_System.Models;

import com.example.BookMyShow_System.Enums.FacilitiesEnum;
import com.example.BookMyShow_System.Enums.LocationEnum;
import com.example.BookMyShow_System.Enums.RatingEnum;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String address; //can set diffrent attr for location so that they can get filter using location
    private String location;
    //Mapping Theatre -> Show
    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    private List<Show> showList = new ArrayList<>();

    //Mapping Theatre -> TheatreSeat
    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    private List<TheatreSeat> theatreSeatList = new ArrayList<>();

}
