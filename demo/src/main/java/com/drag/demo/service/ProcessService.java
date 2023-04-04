package com.drag.demo.service;

import com.drag.demo.model.Process;

import com.drag.demo.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProcessService {
    private final ProcessRepository processRepository;

    public Process readProcess(Long id) {
        Optional<Process> process = processRepository.findById(id);
        if (process.isPresent()) {
            return process.get();
        }
        throw new EntityNotFoundException(
                "Cant find any process under given ID");
    }

    public List<Process> readProcesses() {
        return processRepository.findAll();
    }

}

