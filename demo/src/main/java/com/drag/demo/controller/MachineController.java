package com.drag.demo.controller;

import com.drag.demo.model.Machine;
import com.drag.demo.model.request.MachineCreationRequest;
import com.drag.demo.service.MachineService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/machine")
@RequiredArgsConstructor

public class MachineController {
    private final MachineService machineService;

    @PostMapping("")
    public ResponseEntity<Machine> createMachine(@RequestBody MachineCreationRequest request) {
        return ResponseEntity.ok(machineService.createMachine(request));
    }
    @PatchMapping("/{Id}")
    public ResponseEntity<Machine> updateMachine(@RequestBody MachineCreationRequest request, @PathVariable Long Id) {
        return ResponseEntity.ok(machineService.updateMachine(Id, request));
    }

}
