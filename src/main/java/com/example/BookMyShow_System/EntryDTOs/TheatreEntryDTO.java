package com.example.BookMyShow_System.EntryDTOs;

import com.example.BookMyShow_System.Enums.LocationEnum;
import lombok.Data;

@Data
public class TheatreEntryDTO {
    //Attr that we require
    private String name;
    private String address;
    private LocationEnum location;
    private int classicSeatCount;
    private int premiumSeatCount;
}
