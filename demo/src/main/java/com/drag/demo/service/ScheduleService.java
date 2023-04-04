package com.drag.demo.service;

import com.drag.demo.model.*;
import com.drag.demo.model.request.ScheduleCreationRequest;
import com.drag.demo.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final MachineRepository machineRepository;
    private final ScheduleRepository scheduleRepository;



    public Schedule createSchedule(ScheduleCreationRequest request) {
        Optional<Machine> machine = machineRepository.findById(request.getPcm_id());
        if (!machine.isPresent()) {
            throw new EntityNotFoundException(
                    "machine Not Found");
        }
        Schedule schedule = new Schedule();
        BeanUtils.copyProperties(request, schedule);
        schedule.setMachine(machine.get());
        return scheduleRepository.save(schedule);
    }


    public Schedule updateSchedule(Long id, ScheduleCreationRequest request) {
        Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);
        if (!optionalSchedule.isPresent()) {
            throw new EntityNotFoundException(
                    "OrderProcess not present in the database");
        }

        Schedule schedule = optionalSchedule.get();

        Machine newMachine = machineRepository.findById(request.getPcm_id()).orElseThrow(() -> new EntityNotFoundException());

        schedule.setMachine(newMachine);
        schedule.setSchedule(request.getSchedule());
        return scheduleRepository.save(schedule);
    }
}

