package com.drag.demo.controller;

import com.drag.demo.model.OrderProcess;
import com.drag.demo.model.request.OrderProcessCreationRequest;
import com.drag.demo.service.OrderProcessService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/orderProcess")
@RequiredArgsConstructor
public class OrderProcessController {
    private final OrderProcessService orderProcessService;


    @PostMapping("")
    public ResponseEntity<OrderProcess> createOrderProcess(@RequestBody OrderProcessCreationRequest request) {
        return ResponseEntity.ok(orderProcessService.createOrderProcess(request));
    }

    @PatchMapping("/{Id}")
    public ResponseEntity<OrderProcess> updateOrderProcess(@RequestBody OrderProcessCreationRequest request, @PathVariable Long Id) {
        return ResponseEntity.ok(orderProcessService.updateOrderProcess(Id, request));
    }
    @DeleteMapping("/{Id}")
    public ResponseEntity<OrderProcess> updateOrderProcess(@PathVariable Long Id) {
        orderProcessService.deleteOrderProcess(Id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{pId}/{cId}")
    public ResponseEntity readOrderProcess(@PathVariable Long pId, @PathVariable Long cId) {
        return ResponseEntity.ok(orderProcessService.readOrderProcess(pId, cId));
    }
}
