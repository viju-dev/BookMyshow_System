package com.example.BookMyShow_System.Controllers;

import com.example.BookMyShow_System.EntryDTOs.UserEntryDTO;
import com.example.BookMyShow_System.Models.Ticket;
import com.example.BookMyShow_System.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody UserEntryDTO userEntryDTO){
        try {
            String result = userService.addUser(userEntryDTO);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        catch (Exception e){
            String response = "User not created";
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("GetAllTickets")
    public ResponseEntity GetAllTickets(@RequestParam("id") int id){
        List<Ticket> ticketList = userService.GetAllTickets(id);
        return new ResponseEntity<>(ticketList,HttpStatus.FOUND);
    }


}
