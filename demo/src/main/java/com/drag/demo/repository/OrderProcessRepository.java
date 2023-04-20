package com.drag.demo.repository;

import com.drag.demo.model.MapProcess;
import com.drag.demo.model.OrderProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderProcessRepository extends JpaRepository<OrderProcess, Long> {
    @Query(value = "select cname, pname, idx, mname, p2.id as prid ,job, o.id as oid, m.id as mid, category from product p " +
            "left join company c on c.id = p.c_id " +
            "left join order_process o on o.pc_id = p.id " +
            "left join process p2 on p2.id = o.p_id " +
            "left join machine m on m.o_id = o.id " +
            "where p.id = :pId and c.id = :cId "
            , nativeQuery = true)
    List<MapProcess> findByProduct_Company_Machine_Schedule_Ids(@Param("pId") Long pId, @Param("cId") Long cId);

}
