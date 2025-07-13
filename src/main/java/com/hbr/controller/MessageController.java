package com.hbr.controller;

import com.hbr.model.Message;
import com.hbr.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @GetMapping
    public List<Message> getAll() {
        return messageService.getAll();
    }

    @PostMapping
    public Message send(@RequestBody Message message) {
        return messageService.envoyer(message);
    }
}
