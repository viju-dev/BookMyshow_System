package com.example.BookMyShow_System.Repositries;

import com.example.BookMyShow_System.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
