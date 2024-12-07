package com.example.backend.controller;

import com.example.backend.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
public class MessageController {

    private final MessageService messageService;

    @GetMapping("/message")
    public Map<String, String> getMessage(@RequestParam Long id) {
        String content = messageService.getMessageById(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", content);
        return response;
    }
}
