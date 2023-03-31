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
@Table(name="machine")
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String mname;

    @ManyToOne
    @JoinColumn(name = "pc_id")
    @JsonManagedReference
    private Product product;

    @JsonBackReference
    @OneToMany(mappedBy = "machine", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Schedule> schedule;
}
