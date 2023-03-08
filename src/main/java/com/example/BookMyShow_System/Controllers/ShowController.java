package com.example.BookMyShow_System.Controllers;

import com.example.BookMyShow_System.EntryDTOs.ShowEntryDTO;
import com.example.BookMyShow_System.Models.Show;
import com.example.BookMyShow_System.ResponseDTOs.ShowResponseDTO;
import com.example.BookMyShow_System.Services.ShowService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/shows")
public class ShowController {
    @Autowired
    ShowService showService;
    @PostMapping("/addShow")
    public ResponseEntity addShow(@RequestBody ShowEntryDTO showEntryDTO){
        try {
            String result = showService.addShow(showEntryDTO);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        catch (Exception e){
            String response = "Show Not Added";
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }
    //get SHOWtimes by moviename,thetarename
    @GetMapping("/GetShowTime")
    public ResponseEntity GetShowTime(@RequestParam("movieName") String movieName,@RequestParam("theatreId") int theatreId){
        List<ShowResponseDTO> showList = showService.GetShowTime(movieName,theatreId);
        return new ResponseEntity<>(showList,HttpStatus.FOUND);
    }
    @GetMapping("/GetShowTimes")
    public ResponseEntity GetShowTimes(@RequestParam("location") String location,@RequestParam("movieName") String movieName,@RequestParam("theatreName") String theatreName){
        List<ShowResponseDTO> showList = showService.GetShowTimes(location,movieName,theatreName);

        return new ResponseEntity(showList,HttpStatus.FOUND);
    }
    //getTheatres with shows by location and movie
//    @GetMapping("/GetShowTimesByMovieAndLocation")
//    public ResponseEntity GetShowTimesByMovieAndLocation(@RequestParam("location") String location,@RequestParam("movieName") String movieName){
//        List<Show> showList = showService.GetShowTimes(location,movieName,theatreName);
//        return new ResponseEntity(showList,HttpStatus.FOUND);
//    }

    //getshow by date AND time
    //getshow by date AND time AND location
    //getShows by theatre
    //getshows by moviename for user-best/movie id/movies;
    //delete show
    //deleteAll

    //getalltheatre and shows by location
    //getShowsByMovie
    @GetMapping("/GetShowsByMovie")
    public ResponseEntity GetShowsByMovie(@RequestParam("movieName") String movieName){
        List<ShowResponseDTO> showList = showService.GetShowsByMovie(movieName);
        return new ResponseEntity<>(showList,HttpStatus.FOUND);
    }
    //getshows bydate
    @GetMapping("/GetShowsByDate")
    public ResponseEntity GetShowsByDate(@RequestParam("date") String date){
        List<ShowResponseDTO> showList = showService.GetShowsByDate(date);
        return new ResponseEntity<>(showList,HttpStatus.FOUND);
    }
    //getshows by date and movie
    @GetMapping("/GetShowsByMovieAndDate")
    public ResponseEntity GetShowsByMovieAndDate(@RequestParam("movieName") String movieName, @RequestParam("date") String date ){
        List<ShowResponseDTO> showList = showService.GetShowsByMovieAndDate(movieName,date);
        return new ResponseEntity<>(showList,HttpStatus.FOUND);
    }
    @GetMapping("/GetShowsByTheatreAndMovie")
    public ResponseEntity GetShowsByTheatreAndMovie(@RequestParam("theatreId") int theatreId, @RequestParam("movieName") String movieName ){
        List<ShowResponseDTO> showList = showService.GetShowsByTheatreAndMovie(theatreId,movieName);
        return new ResponseEntity<>(showList,HttpStatus.FOUND);
    }

}
