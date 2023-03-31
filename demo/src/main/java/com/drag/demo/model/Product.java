package com.drag.demo.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String pname;
    private long idx;

    @ManyToOne
    @JoinColumn(name = "c_id")
    @JsonManagedReference
    private Company company;

    @ManyToOne
    @JoinColumn(name = "p_id")
    @JsonManagedReference
    private Process process;

    @JsonBackReference
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Machine> machine;
}
