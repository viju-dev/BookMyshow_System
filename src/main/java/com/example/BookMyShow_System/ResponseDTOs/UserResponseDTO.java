package com.example.BookMyShow_System.ResponseDTOs;

import com.example.BookMyShow_System.Enums.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
    private String name;
    private int age;
    private GenderEnum gender;
    private String mobNo;
    private String email;
    private String address;
}
