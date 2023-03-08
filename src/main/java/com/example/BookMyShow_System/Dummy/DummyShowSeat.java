package com.example.BookMyShow_System.Dummy;

import com.example.BookMyShow_System.Enums.SeatTypeEnum;
import com.example.BookMyShow_System.Models.Show;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

//@Entity
//@Table
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
public class DummyShowSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int seatNo;
    private boolean isBooked;
    @Enumerated(EnumType.STRING)
    private SeatTypeEnum seatType;
    private int price; //price of CLASSIC Seat for that particular
    //book Date
    private Date bookedAt;

    //Mapping ShowSeat -> Show
    @ManyToOne
    @JoinColumn
    private Show show;

}
