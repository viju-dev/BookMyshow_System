package com.example.BookMyShow_System.Converters;

import com.example.BookMyShow_System.EntryDTOs.TheatreEntryDTO;
import com.example.BookMyShow_System.Enums.LocationEnum;
import com.example.BookMyShow_System.Models.Theatre;
import com.example.BookMyShow_System.ResponseDTOs.TheatreResponseDTO;

public class TheatreConvertors {

    public static Theatre EntryToEntity(TheatreEntryDTO theatreEntryDTO){
        String location = theatreEntryDTO.getLocation().name();
        Theatre theatre = Theatre.builder()
                .name(theatreEntryDTO.getName())
                .address(theatreEntryDTO.getAddress())
                .location(location)
                .build();
        return theatre;
    }
    public static TheatreResponseDTO EntityToResponse(Theatre theatre){
//        String location = theatre.getLocation();
        TheatreResponseDTO theatreResponseDTO = TheatreResponseDTO.builder()
                .name(theatre.getName())
                .address(theatre.getAddress())
                .location(theatre.getLocation())
                .build();
        return theatreResponseDTO;
    }
}
