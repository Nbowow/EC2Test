package com.example.backend.Repository;

import com.example.backend.controller.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
