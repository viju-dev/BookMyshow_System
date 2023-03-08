package com.example.BookMyShow_System.Repositries;

import com.example.BookMyShow_System.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
    List<Ticket> findByUserId(int userId);
}
