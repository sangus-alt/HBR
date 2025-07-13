package com.hbr.service;

import com.hbr.model.Planning;
import com.hbr.repository.PlanningRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanningService {

    private final PlanningRepository planningRepository;

    public List<Planning> getAll() {
        return planningRepository.findAll();
    }

    public Planning save(Planning planning) {
        return planningRepository.save(planning);
    }

    public void delete(Long id) {
        planningRepository.deleteById(id);
    }
}
