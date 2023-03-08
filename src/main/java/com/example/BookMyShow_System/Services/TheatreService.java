package com.example.BookMyShow_System.Services;

import com.example.BookMyShow_System.Converters.TheatreConvertors;
import com.example.BookMyShow_System.EntryDTOs.TheatreEntryDTO;
import com.example.BookMyShow_System.Enums.SeatTypeEnum;
import com.example.BookMyShow_System.Models.Show;
import com.example.BookMyShow_System.Models.Theatre;
import com.example.BookMyShow_System.Models.TheatreSeat;
import com.example.BookMyShow_System.Repositries.ShowRepository;
import com.example.BookMyShow_System.Repositries.TheatreRepository;
import com.example.BookMyShow_System.Repositries.TheatreSeatRepository;
import com.example.BookMyShow_System.ResponseDTOs.ShowResponseDTO;
import com.example.BookMyShow_System.ResponseDTOs.TheatreResponseDTO;
import com.example.BookMyShow_System.ResponseDTOs.TheatreShowsResponnseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreService {
    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    TheatreSeatRepository theatreSeatRepository;
    @Autowired
    ShowRepository showRepository;

    public String addTheatre(TheatreEntryDTO theatreEntryDTO) throws RuntimeException{
        Theatre theatre = TheatreConvertors.EntryToEntity(theatreEntryDTO);
        //if theatre with same name and location already exist though an exception
        if (theatreRepository.existsByNameAndLocation(theatre.getName(),theatre.getLocation())){//findByLastnameAndFirstname
            throw new RuntimeException("Theatre with same name and location already exists");
        }
        //get seatslist and set seatlist of theatre
        List<TheatreSeat> seatList = addSeats(theatre,theatreEntryDTO);
        theatre.setTheatreSeatList(seatList);
        //saving theatre
        theatreRepository.save(theatre);
        return "Theatre Successfully added";
    }
    public List<TheatreSeat> addSeats(Theatre theatre,TheatreEntryDTO theatreEntryDTO){
        //taking this two extra attr from theatre Entry Dto
        int classicSeats = theatreEntryDTO.getClassicSeatCount();
        int premiumSeats = theatreEntryDTO.getPremiumSeatCount();

        //get seatslist and set seatlist of theatre
        List<TheatreSeat> seatList = new ArrayList<>();//theatre.getTheatreSeatList(); //was giving error of null arraylist

        //for classic seats
        for (int i=1;i<=classicSeats;i++){
            TheatreSeat theatreSeat = new TheatreSeat();
            theatreSeat.setSeatNo(i+"C");
            theatreSeat.setType(SeatTypeEnum.C);
            theatreSeat.setTheatre(theatre); //optional ig
//            theatreSeatRepository.save(theatreSeat);
            seatList.add(theatreSeat);
            System.out.println(seatList.size());
        }

        //for premium seats
        for (int i=1;i<=premiumSeats;i++){
            TheatreSeat theatreSeat = new TheatreSeat();
            theatreSeat.setSeatNo(i+"P");
            theatreSeat.setType(SeatTypeEnum.P);
            theatreSeat.setTheatre(theatre);
//            theatreSeatRepository.save(theatreSeat);
            seatList.add(theatreSeat);
            System.out.println(seatList.size());
        }
        theatreRepository.save(theatre);
        //not saving child here
        return seatList;
    }

    public List<Theatre> GetTheatresByTime(LocalDate date) {
        List<Theatre> theatreList = new ArrayList<>();
        return theatreList;
    }


    public List<TheatreShowsResponnseDTO> GetAllTheatreShowsBy(String location, String movieName) {
        List<TheatreShowsResponnseDTO> theatreList = new ArrayList<>();
//        for (Theatre theatre:theatreRepository.findByLocationAndMovieName(location,movieName)){
//
//        }
        return theatreList;
    }

    public List<TheatreResponseDTO> GetAllByLocation(String location) {
        List<TheatreResponseDTO> theatreList  = new ArrayList<>();
        for (Theatre theatre:theatreRepository.findByLocation(location)){
            theatreList.add(TheatreConvertors.EntityToResponse(theatre));
        }
        return theatreList;
    }

    public List<TheatreResponseDTO> GetAll() {
        List<TheatreResponseDTO> theatreList = new ArrayList<>();
        for (Theatre theatre:theatreRepository.findAll()){
            theatreList.add(TheatreConvertors.EntityToResponse(theatre));
        }
        return theatreList;
    }

    public List<TheatreResponseDTO> GetByTime(String date) {
        LocalDate localDate = LocalDate.parse(date);
        List<Integer> theatreIds = showRepository.findByShowDate(localDate);
        List<TheatreResponseDTO> theatreList = new ArrayList<>();
        for (int id:theatreIds){
            theatreList.add(TheatreConvertors.EntityToResponse(theatreRepository.findById(id).get()));
        }
        return theatreList;
    }
}
