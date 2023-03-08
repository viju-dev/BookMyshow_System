package com.example.BookMyShow_System.Controllers;

import com.example.BookMyShow_System.EntryDTOs.TicketEntryDTO;
import com.example.BookMyShow_System.ResponseDTOs.TicketResponseDTO;
import com.example.BookMyShow_System.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    TicketService ticketService;
    @PostMapping("/addTicket")
    public ResponseEntity addTicket(@RequestBody TicketEntryDTO ticketEntryDTO){
        String response = ticketService.addTicket(ticketEntryDTO);
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }

    @GetMapping("/GetAllByUser")
    public ResponseEntity GetAllByUser(@RequestParam("userId") int userId){
        List<TicketResponseDTO> ticketList = ticketService.GetAllByUser(userId);
        return new ResponseEntity<>(ticketList, HttpStatus.FOUND);
    }



}
