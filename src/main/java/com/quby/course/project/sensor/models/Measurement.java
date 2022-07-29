package com.quby.course.project.sensor.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

@Entity
@Table(name = "meterage")
public class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "measure_id")
    private Integer id;

    @Min(-100)
    @Max(100)
    //@NotEmpty
    @Column(name = "air_temperature")
    private Double airTemperature;

    @Column(name = "raining")
    private Boolean raining;

    //@NotEmpty()
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "measurement_time")
    private Date measurementTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sensor", referencedColumnName = "name")
    private Sensor sensor;

    public Measurement() {
    }

    public Measurement(Double airTemperature, Boolean raining, Date measurementTime) {
        this.airTemperature = airTemperature;
        this.raining = raining;
        this.measurementTime = measurementTime;
    }

    public Measurement(Double airTemperature, Boolean raining, Date measurementTime, Sensor sensor) {
        this.airTemperature = airTemperature;
        this.raining = raining;
        this.measurementTime = measurementTime;
        this.sensor = sensor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAirTemperature() {
        return airTemperature;
    }

    public void setAirTemperature(Double airTemperature) {
        this.airTemperature = airTemperature;
    }

    public Boolean getRaining() {
        return raining;
    }

    public void setRaining(Boolean raining) {
        this.raining = raining;
    }

    public Date getMeasurementTime() {
        return measurementTime;
    }

    public void setMeasurementTime(Date measurementTime) {
        this.measurementTime = measurementTime;
    }

    @JsonBackReference
    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    @Override
    public String toString() {
        return "Measure{" +
                "id=" + id +
                ", airTemperature=" + airTemperature +
                ", raining=" + raining +
                ", measurementTime=" + measurementTime +
                ", sensor=" + sensor +
                '}';
    }
}
