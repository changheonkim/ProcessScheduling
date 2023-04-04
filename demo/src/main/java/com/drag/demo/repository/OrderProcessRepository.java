package com.drag.demo.repository;

import com.drag.demo.model.MapProcess;
import com.drag.demo.model.OrderProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderProcessRepository extends JpaRepository<OrderProcess, Long> {
    @Query(value = "select cname, pname, idx, mname, job, category from company c " +
            "left join product p on c.id = p.c_id " +
            "left join order_process p2 on p2.p_id = p.id " +
            "left join process p3 on p2.pc_id = p3.id " +
            "left join machine m on m.o_id = p2.id " +
            "where p.id = :pId and c.id = :cId "
            , nativeQuery = true)
    List<MapProcess> findByProduct_Company_Machine_Schedule_Ids(@Param("pId") Long pId, @Param("cId") Long cId);

}
