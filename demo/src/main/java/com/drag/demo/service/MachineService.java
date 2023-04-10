package com.drag.demo.service;

import com.drag.demo.model.*;
import com.drag.demo.model.request.MachineCreationRequest;
import com.drag.demo.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MachineService {
    private final MachineRepository machineRepository;
    private final ProductRepository productRepository;

    private final OrderProcessRepository orderProcessRepository;

    public Machine createMachine(MachineCreationRequest request) {
        Optional<Product> product = productRepository.findById(request.getPc_id());

        Machine machine = new Machine();
        if (!product.isPresent()) {
            throw new EntityNotFoundException(
                    "product Not Found");
        }

        if (request.getO_id() == null) {
            BeanUtils.copyProperties(request, machine);
            machine.setProduct(product.get());
            machine.setOrderProcess(null);
            return machineRepository.save(machine);
        }

        Optional<OrderProcess> orderProcess = orderProcessRepository.findById(request.getO_id());
        if (!orderProcess.isPresent()) {
            throw new EntityNotFoundException(
                    "process Not Found");
        }

        BeanUtils.copyProperties(request, machine);
        machine.setProduct(product.get());
        machine.setOrderProcess(orderProcess.get());
        return machineRepository.save(machine);
    }

    public Machine updateMachine(Long id, MachineCreationRequest request) {
        Optional<Machine> optionalMachine = machineRepository.findById(id);
        if (!optionalMachine.isPresent()) {
            throw new EntityNotFoundException(
                    "OrderProcess not present in the database");
        }

        Machine machine = optionalMachine.get();

        Product newProduct = productRepository.findById(request.getPc_id()).orElseThrow(() -> new EntityNotFoundException());
        OrderProcess newOrderProcess = orderProcessRepository.findById(request.getO_id()).orElseThrow(() -> new EntityNotFoundException());
        machine.setProduct(newProduct);
        machine.setOrderProcess(newOrderProcess);


        machine.setMname(request.getMname());
        return machineRepository.save(machine);
    }
}

