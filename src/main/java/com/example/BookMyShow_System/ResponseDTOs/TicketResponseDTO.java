package com.example.BookMyShow_System.ResponseDTOs;

import com.example.BookMyShow_System.Models.Show;
import com.example.BookMyShow_System.Models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketResponseDTO {

    private String movieName;
    private LocalDate showDate;
    private LocalTime showTime;
    private int totalAmount;
    private String ticketId;
    private String theaterName;
    private String bookedSeats;

//    private User user;
//
//    private Show show;
}
