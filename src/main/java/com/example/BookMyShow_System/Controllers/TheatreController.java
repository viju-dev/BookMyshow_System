package com.example.BookMyShow_System.Controllers;

import com.example.BookMyShow_System.EntryDTOs.TheatreEntryDTO;
import com.example.BookMyShow_System.Models.Show;
import com.example.BookMyShow_System.Models.Theatre;
import com.example.BookMyShow_System.ResponseDTOs.ShowResponseDTO;
import com.example.BookMyShow_System.ResponseDTOs.TheatreResponseDTO;
import com.example.BookMyShow_System.ResponseDTOs.TheatreShowsResponnseDTO;
import com.example.BookMyShow_System.Services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/theatres")
public class TheatreController {
    @Autowired
    TheatreService theatreService;

    @PostMapping("/add")
    public ResponseEntity addTheatre(@RequestBody TheatreEntryDTO theatreEntryDTO){
        try {
            String result =  theatreService.addTheatre(theatreEntryDTO);
            return new ResponseEntity<>(result, HttpStatus.CREATED);

        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("GetTheatresByTime") //thetare having shows at apecific time
    public ResponseEntity GetTheatresByTime(@RequestParam("date") LocalDate date){
        List<Theatre> theatreList = theatreService.GetTheatresByTime(date);
        return new ResponseEntity<>(theatreList,HttpStatus.FOUND);
    }
    //getTheatres with shows by location and movie
    @GetMapping("/GetAllTheatreShowsBy")
    public ResponseEntity GetAllTheatreShowsBy(@RequestParam("location") String location,@RequestParam("movieName") String movieName){
        List<TheatreShowsResponnseDTO> theatreList = theatreService.GetAllTheatreShowsBy(location,movieName);
        return new ResponseEntity(theatreList,HttpStatus.FOUND);
    }

    //getAll theatres by location
    @GetMapping("/GetAllByLocation")
    public ResponseEntity GetAllByLocation(@RequestParam("location") String location){
        List<TheatreResponseDTO> theatreList = theatreService.GetAllByLocation(location);
        return new ResponseEntity(theatreList,HttpStatus.FOUND);
    }
    @GetMapping("/GetAll")
    public ResponseEntity GetAll(){
        List<TheatreResponseDTO> theatreList = theatreService.GetAll();
        return new ResponseEntity<>(theatreList,HttpStatus.FOUND);
    }
    @GetMapping("/GetByTime")
    public ResponseEntity GetByTime(@RequestParam("date") String date){
        List<TheatreResponseDTO> theatreList = theatreService.GetByTime(date);
        return new ResponseEntity<>(theatreList,HttpStatus.FOUND);
    }
}
