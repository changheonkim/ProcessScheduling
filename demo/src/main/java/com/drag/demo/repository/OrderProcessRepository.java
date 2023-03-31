package com.drag.demo.repository;

import com.drag.demo.model.OrderProcess;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProcessRepository extends JpaRepository<OrderProcess, Long> {
}
