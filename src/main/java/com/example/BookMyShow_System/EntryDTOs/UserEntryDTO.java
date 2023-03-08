package com.example.BookMyShow_System.EntryDTOs;

import com.example.BookMyShow_System.Enums.GenderEnum;
import com.example.BookMyShow_System.Enums.LocationEnum;
import lombok.Data;

@Data
public class UserEntryDTO {
    private String name;
    private int age;
    private GenderEnum gender;
    private String mobNo;
    private String email;
    private String address;
    //private LocationEnum location;
}
