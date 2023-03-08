package com.example.BookMyShow_System.Converters;

import com.example.BookMyShow_System.EntryDTOs.UserEntryDTO;
import com.example.BookMyShow_System.Models.User;

public class UserConvertors {
    public static User EntryToEntity(UserEntryDTO userEntryDTO){
        User user = User.builder()
                .name(userEntryDTO.getName())
                .age(userEntryDTO.getAge())
                .gender(userEntryDTO.getGender())
                .mobNo(userEntryDTO.getMobNo())
                .email(userEntryDTO.getEmail())
                .address(userEntryDTO.getAddress())
                .build();
        //                .location(userEntryDTO.getLocation())
        return user;
    }
}
