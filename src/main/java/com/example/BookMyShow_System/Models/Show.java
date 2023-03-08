package com.example.BookMyShow_System.Models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "shows")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate showDate;
    private LocalTime showTime;
    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

//    @Enumerated(EnumType.STRING)
//    private ScreenTypeEnum screenType;
    private String screenType;

    //Mapping Show -> Theatre
    @ManyToOne
    @JoinColumn
    private Theatre theatre;

    //Mapping Show -> Movie
    @ManyToOne
    @JoinColumn
    private Movie movie;
//private

    //Mapping Show -> Ticket
    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<Ticket> ticketList = new ArrayList<>();

    //Mapping Show -> ShowSeat
    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<ShowSeat> showSeatList = new ArrayList<>();
}
