package com.example.BookMyShow_System.Models;

import com.example.BookMyShow_System.Enums.SeatTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class TheatreSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String seatNo;

    @Enumerated(EnumType.STRING)
    private SeatTypeEnum type;

    //Mapping TheatreSeat -> Theatre
    @ManyToOne
    @JoinColumn
    private Theatre theatre;
}
