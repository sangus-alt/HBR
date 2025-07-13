package com.hbr.service;

import com.hbr.model.Reservation;
import com.hbr.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    public Reservation getById(Long id) {
        return reservationRepository.findById(id).orElseThrow();
    }

    public Reservation create(Reservation r) {
        return reservationRepository.save(r);
    }

    public void delete(Long id) {
        reservationRepository.deleteById(id);
    }
}
