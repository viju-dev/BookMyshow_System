package com.example.BookMyShow_System.Dummy;

import com.example.BookMyShow_System.Models.Show;
import com.example.BookMyShow_System.Models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

//@Entity
//@Table
//@Builder
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class DummyTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String movieName;
    private LocalDate showDate;
    private LocalTime showTime;
    private int totalAmount;
    private String ticketId = UUID.randomUUID().toString();
    private String theaterName;

    //Mapping Ticket -> User
    @ManyToOne
    @JoinColumn
    private User user;

    //Mapping Ticket -> Show
    @ManyToOne
    @JoinColumn
    private Show show;

}
