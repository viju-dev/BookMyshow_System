package com.example.BookMyShow_System.Models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String movieName;
    private LocalDate showDate;
    private LocalTime showTime;
    private int totalAmount;
    private String ticketId = UUID.randomUUID().toString();
    private String theaterName;
    private String bookedSeats;

    //Mapping Ticket -> User
    @ManyToOne
    @JoinColumn
    private User user;

    //Mapping Ticket -> Show
    @ManyToOne
    @JoinColumn
    private Show show;


}
