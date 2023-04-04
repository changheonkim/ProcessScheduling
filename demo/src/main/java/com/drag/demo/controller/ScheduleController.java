package com.drag.demo.controller;

import com.drag.demo.model.Schedule;
import com.drag.demo.model.request.ScheduleCreationRequest;
import com.drag.demo.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/schedule")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping("")
    public ResponseEntity<Schedule> createSchedule(@RequestBody ScheduleCreationRequest request) {
        return ResponseEntity.ok(scheduleService.createSchedule(request));
    }


    @PatchMapping("/{Id}")
    public ResponseEntity<Schedule> updateSchedule(@RequestBody ScheduleCreationRequest request, @PathVariable Long Id) {
        return ResponseEntity.ok(scheduleService.updateSchedule(Id, request));
    }
}
