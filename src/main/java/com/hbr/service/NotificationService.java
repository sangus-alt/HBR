package com.hbr.service;

import com.hbr.model.Notification;
import com.hbr.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public List<Notification> getAll() {
        return notificationRepository.findAll();
    }

    public Notification envoyer(Notification n) {
        n.setDate(LocalDateTime.now());
        n.setLu(false);
        return notificationRepository.save(n);
    }
}
