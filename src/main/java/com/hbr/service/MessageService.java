package com.hbr.service;

import com.hbr.model.Message;
import com.hbr.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    public Message envoyer(Message m) {
        m.setDateEnvoi(LocalDateTime.now());
        return messageRepository.save(m);
    }
}
