package com.drag.demo.model;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name="schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private java.sql.Date schedule;

    @ManyToOne
    @JoinColumn(name = "pcm_id")
    @JsonManagedReference
    private Machine machine;
}
