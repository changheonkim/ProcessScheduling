package com.drag.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.Proc;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name="orderProcess")
public class OrderProcess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long idx;

    @ManyToOne
    @JoinColumn(name = "pc_id")
    @JsonManagedReference
    private Product product;

    @ManyToOne
    @JoinColumn(name = "p_id")
    @JsonManagedReference
    private Process process;

    @JsonBackReference
    @OneToMany(mappedBy = "orderProcess", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Machine> machines;
}
