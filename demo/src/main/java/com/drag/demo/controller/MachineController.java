package com.drag.demo.controller;

import com.drag.demo.model.Machine;
import com.drag.demo.model.OrderProcess;
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

    @DeleteMapping("/{Id}")
    public ResponseEntity<Machine> deleteMachine(@PathVariable Long Id) {
        machineService.deleteMachine(Id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{pId}")
    public ResponseEntity readMachine(@PathVariable Long pId) {
        return ResponseEntity.ok(machineService.readMachine(pId));
    }

    @PostMapping("/{Id}")
    public ResponseEntity<Machine> createMachine(@RequestBody MachineCreationRequest request, @PathVariable Long Id) {
        return ResponseEntity.ok(machineService.createMachine(Id, request));
    }

    @PatchMapping("/{Id}")
    public ResponseEntity<Machine> updateMachine(@RequestBody MachineCreationRequest request, @PathVariable Long Id) {
        return ResponseEntity.ok(machineService.updateMachine(Id, request));
    }

}
