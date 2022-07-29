package com.quby.course.project.sensor.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "sensors")
public class Sensor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sensor_id")
    private Integer id;

    @Size(min = 3, max = 30, message = "Sensor name should be between 3 and 30 characters")
    @Column(name = "name", unique = true)
    //@OneToMany(mappedBy = "sensor")
    private String name;

//    @OneToMany(mappedBy = "sensor",
//            orphanRemoval = true,
//            cascade = CascadeType.ALL
//    )
//    private List<Measurement> meterage;

    public Sensor() {
    }

    public Sensor(String name) {
        this.name = name;
    }

    public Sensor(String name, List<Measurement> meterage) {
        this.name = name;
        //this.meterage = meterage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @JsonManagedReference
//    public List<Measurement> getMeterage() {
//        return meterage;
//    }

//    public void setMeterage(List<Measurement> meterage) {
//        this.meterage = meterage;
//    }
//
//    @Override
//    public String toString() {
//        return "Sensor{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", meterage=" + meterage +
//                '}';
//    }
}
