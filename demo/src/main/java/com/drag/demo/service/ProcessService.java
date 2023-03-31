package com.drag.demo.service;

import com.drag.demo.model.*;
import com.drag.demo.model.Process;
import com.drag.demo.model.request.MachineCreationRequest;
import com.drag.demo.model.request.OrderProcessCreationRequest;
import com.drag.demo.model.request.ScheduleCreationRequest;
import com.drag.demo.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProcessService {
    private final CompanyRepository companyRepository;
    private final MachineRepository machineRepository;
    private final ProcessRepository processRepository;
    private final ProductRepository productRepository;
    private final ScheduleRepository scheduleRepository;

    private final OrderProcessRepository orderProcessRepository;
    public Process readProcess(Long id){
        Optional<Process> process = processRepository.findById(id);
        if (process.isPresent()){
            return process.get();
        }
        throw new EntityNotFoundException(
                "Cant find any process under given ID");
    }
    public List<Process> readProcesses(){
        return processRepository.findAll();
    }
    public OrderProcess createOrderProcess (OrderProcessCreationRequest request) {
        Optional<Product> product = productRepository.findById(request.getP_id());
        if(!product.isPresent()){
            throw new EntityNotFoundException(
                    "product Not Found");
        }

        Optional<Process> process = processRepository.findById(request.getPc_id());
        if(!process.isPresent()){
            throw new EntityNotFoundException(
                    "process Not Found");
        }

        OrderProcess orderProcess = new OrderProcess();
        BeanUtils.copyProperties(request, orderProcess);
        orderProcess.setProduct(product.get());
        orderProcess.setProcess(process.get());
        return orderProcessRepository.save(orderProcess);
    }

    public Machine createMachine (MachineCreationRequest request) {
        Optional<Product> product = productRepository.findById(request.getPc_id());
        if(!product.isPresent()){
            throw new EntityNotFoundException(
                    "product Not Found");
        }

        Optional<OrderProcess> orderProcess = orderProcessRepository.findById(request.getO_id());
        if(!orderProcess.isPresent()){
            throw new EntityNotFoundException(
                    "process Not Found");
        }

        Machine machine = new Machine();
        BeanUtils.copyProperties(request, machine);
        machine.setProduct(product.get());
        machine.setOrderProcess(orderProcess.get());
        return machineRepository.save(machine);
    }

    public Schedule createSchedule (ScheduleCreationRequest request) {
        Optional<Machine> machine = machineRepository.findById(request.getPcm_id());
        if(!machine.isPresent()){
            throw new EntityNotFoundException(
                    "machine Not Found");
        }

        Schedule schedule = new Schedule();
        BeanUtils.copyProperties(request, schedule);
        schedule.setMachine(machine.get());
        return scheduleRepository.save(schedule);
    }

//    public OrderProcess updateOrderProcess(Long id, OrderProcessCreationRequest request) {
//        Optional<OrderProcess> optionalOrderProcess = orderProcessRepository.findById(id);
//        if (!optionalOrderProcess.isPresent()) {
//            throw new EntityNotFoundException(
//                    "OrderProcess not present in the database");
//        }
//
//        OrderProcess orderProcess = optionalOrderProcess.get();
//        orderProcess.set
//        return orderProcessRepository.save(member);
//    }
}

