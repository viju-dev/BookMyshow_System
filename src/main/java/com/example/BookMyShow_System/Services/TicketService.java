package com.example.BookMyShow_System.Services;

import com.example.BookMyShow_System.Converters.TheatreConvertors;
import com.example.BookMyShow_System.Converters.TicketConvertors;
import com.example.BookMyShow_System.EntryDTOs.TicketEntryDTO;
import com.example.BookMyShow_System.Models.*;
import com.example.BookMyShow_System.Repositries.ShowRepository;
import com.example.BookMyShow_System.Repositries.TheatreRepository;
import com.example.BookMyShow_System.Repositries.TicketRepository;
import com.example.BookMyShow_System.Repositries.UserRepository;
import com.example.BookMyShow_System.ResponseDTOs.TicketResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TheatreRepository theatreRepository;
    @Autowired
    ShowRepository showRepository;


    public List<TicketResponseDTO> GetAllByUser(int userId) {
        List<TicketResponseDTO> ticketList = new ArrayList<>();
        for (Ticket ticket:ticketRepository.findByUserId(userId)){ //userId or user
            ticketList.add(TicketConvertors.EntityToResponse(ticket));
        }
        return ticketList;
    }

    public String addTicket(TicketEntryDTO ticketEntryDTO){
        Ticket ticket = new Ticket();

        User user = userRepository.findById(ticketEntryDTO.getUserId()).get();
        ticket.setUser(user);
        Show show = showRepository.findById(ticketEntryDTO.getShowId()).get();
        ticket.setShow(show);

        ticket.setMovieName(show.getMovie().getMovieName()); //set moviename
        ticket.setTheaterName(show.getTheatre().getName());

        ticket.setShowDate(show.getShowDate());
        ticket.setShowTime(show.getShowTime());

        ticket.setTicketId(UUID.randomUUID().toString());
        String confirmSeats = "";
        List<ShowSeat> seatList = new ArrayList<>();
        int totalPrice = 0;
        boolean invalidSeat = true;
        for (String reqSeat : ticketEntryDTO.getRequestedSeats()){
            invalidSeat = true;
            for (ShowSeat seat:showRepository.findById(ticketEntryDTO.getShowId()).get().getShowSeatList()){
                if (reqSeat.equals(seat.getSeatNo()) ){
                    invalidSeat = false;
                    if(!seat.isBooked()){
                        System.out.println(seat.isBooked()) ;
                        confirmSeats += seat.getSeatNo()+",";
                        seat.setBooked(true);
                        totalPrice += seat.getPrice();
                        seat.setBookedAt(new Date());
                        seatList.add(seat);
                    }
                    else {
                        throw new RuntimeException("Seat is Not Available");
                    }
                }
//                else {
//                    throw new RuntimeException("Invalid Seat Number Or Seat is Not Available");
//                }
            }
            if (invalidSeat){
                throw new RuntimeException("Invalid seat number");
            }
        }

        ticket.setBookedSeats(confirmSeats);
        ticket.setTotalAmount(totalPrice);

        show.setShowSeatList(seatList);
        show.getTicketList().add(ticket);
        showRepository.save(show); //no need to save tickets
//        ticketRepository.save(ticket);

        return "Tickets booked Succefully";

    }
}
