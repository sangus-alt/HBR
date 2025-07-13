package com.hbr.controller;

import com.hbr.model.Notification;
import com.hbr.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping
    public List<Notification> getAll() {
        return notificationService.getAll();
    }

    @PostMapping
    public Notification send(@RequestBody Notification notification) {
        return notificationService.envoyer(notification);
    }
}
