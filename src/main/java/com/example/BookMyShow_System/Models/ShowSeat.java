package com.example.BookMyShow_System.Models;

import com.example.BookMyShow_System.Enums.SeatTypeEnum;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShowSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String seatNo;
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
