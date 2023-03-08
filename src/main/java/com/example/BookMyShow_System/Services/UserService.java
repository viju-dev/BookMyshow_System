package com.example.BookMyShow_System.Services;

import com.example.BookMyShow_System.Converters.UserConvertors;
import com.example.BookMyShow_System.EntryDTOs.UserEntryDTO;
import com.example.BookMyShow_System.Models.Ticket;
import com.example.BookMyShow_System.Models.User;
import com.example.BookMyShow_System.Repositries.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String addUser(UserEntryDTO userEntryDTO){
        User user = UserConvertors.EntryToEntity(userEntryDTO);
        userRepository.save(user);
        return  "User Created Successfully";
    }

    public List<Ticket> GetAllTickets(int id) {
        return new ArrayList<Ticket>();
    }
}
