package com.example.BookMyShow_System.Dummy;

import com.example.BookMyShow_System.Enums.GenderEnum;
import com.example.BookMyShow_System.Models.Ticket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Entity
//@Table
//@Builder
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class DummyUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // know the differencw
    private int id;

    private String name;
    @Column(unique = true,nullable = false)
    private String mobNo;
    @Column(unique = true,nullable = false)
    private String email;
    private String Address;

    @Enumerated(EnumType.STRING)
    private GenderEnum Gender; // Enum type // optional attribute

//    @JsonFormat(pattern = "dd-MM-yyyy")
//    private Date birthDate;
    private int age;


    //Mapping User -> Tickets
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Ticket> ticketList = new ArrayList<>();

//    //Mapping User -> Order
//    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
//    private List<Order> orderList = new ArrayList<>();


}
