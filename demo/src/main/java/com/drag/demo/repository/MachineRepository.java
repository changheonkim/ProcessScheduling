package com.drag.demo.repository;

import com.drag.demo.model.Machine;
import com.drag.demo.model.MapProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MachineRepository extends JpaRepository<Machine, Long> {
    @Query(value = "select * from machine " +
            "where pc_id = :pId "
            , nativeQuery = true)
    List<Machine> findByMachine_Pc_id(@Param("pId") Long pId);
}
