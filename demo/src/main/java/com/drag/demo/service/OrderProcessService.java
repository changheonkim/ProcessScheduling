package com.drag.demo.service;

import com.drag.demo.model.Process;
import com.drag.demo.model.*;
import com.drag.demo.model.request.OrderProcessCreationRequest;
import com.drag.demo.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderProcessService {
    private final ProcessRepository processRepository;
    private final ProductRepository productRepository;

    private final OrderProcessRepository orderProcessRepository;


    public List<MapProcess> readOrderProcess(Long pId, Long cId) {
        return orderProcessRepository.findByProduct_Company_Machine_Schedule_Ids(pId, cId);
    }

    public void deleteOrderProcess(Long id) {
        orderProcessRepository.deleteById(id);
    }

    public OrderProcess createOrderProcess(OrderProcessCreationRequest request, Long id) {
        if (id == 0) {
            Optional<Product> product = productRepository.findById(request.getP_id());
            if (!product.isPresent()) {
                throw new EntityNotFoundException(
                        "product Not Found");
            }

            Optional<Process> process = processRepository.findById(request.getPc_id());
            if (!process.isPresent()) {
                throw new EntityNotFoundException(
                        "process Not Found");
            }

            OrderProcess orderProcess = new OrderProcess();
            BeanUtils.copyProperties(request, orderProcess);
            orderProcess.setProduct(product.get());
            orderProcess.setProcess(process.get());
            return orderProcessRepository.save(orderProcess);
        } else {
            Optional<OrderProcess> optionalOrderProcess = orderProcessRepository.findById(id);
            if (!optionalOrderProcess.isPresent()) {
                throw new EntityNotFoundException(
                        "OrderProcess not present in the database");
            }

            OrderProcess orderProcess = optionalOrderProcess.get();

            Product newProduct = productRepository.findById(request.getP_id()).orElseThrow(() -> new EntityNotFoundException());
            Process newProcess = processRepository.findById(request.getPc_id()).orElseThrow(() -> new EntityNotFoundException());

            orderProcess.setProduct(newProduct);
            orderProcess.setProcess(newProcess);
            orderProcess.setIdx(request.getIdx());

            return orderProcessRepository.save(orderProcess);
        }

    }


    public OrderProcess updateOrderProcess(Long id, OrderProcessCreationRequest request) {
        Optional<OrderProcess> optionalOrderProcess = orderProcessRepository.findById(id);
        if (!optionalOrderProcess.isPresent()) {
            throw new EntityNotFoundException(
                    "OrderProcess not present in the database");
        }

        OrderProcess orderProcess = optionalOrderProcess.get();

        Product newProduct = productRepository.findById(request.getP_id()).orElseThrow(() -> new EntityNotFoundException());
        Process newProcess = processRepository.findById(request.getPc_id()).orElseThrow(() -> new EntityNotFoundException());

        orderProcess.setProduct(newProduct);
        orderProcess.setProcess(newProcess);
        orderProcess.setIdx(request.getIdx());

        return orderProcessRepository.save(orderProcess);
    }

}

