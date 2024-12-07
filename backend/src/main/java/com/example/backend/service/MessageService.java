package com.example.backend.service;

import com.example.backend.Repository.MessageRepository;
import com.example.backend.controller.entity.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageService {

    private final MessageRepository messageRepository;

    public String getMessageById(Long id) {
        Optional<Message> message = messageRepository.findById(id);
        // content만 로그 출력
        String content = message.map(Message::getContent).orElse("Message not found");
        log.info("Message content: {}", content);

        return content;
    }
}
