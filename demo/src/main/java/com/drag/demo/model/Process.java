package com.drag.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name="process")
public class Process {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String job;
    private String category;
    @JsonBackReference
    @OneToMany(mappedBy = "process", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Product> products;
}
