package com.drag.demo.controller;

import com.drag.demo.service.ProcessService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping(value = "/api/process")
@RequiredArgsConstructor
public class ProcessController {
    private final ProcessService processService;

    @GetMapping("")
    public ResponseEntity readProcesses() {
        return ResponseEntity.ok(processService.readProcesses());
    }

}