package com.quby.course.project.sensor.dtos;

import com.quby.course.project.sensor.models.Sensor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class MeasurementDTO {
    @Min(-100)
    @Max(100)
    private Double airTemperature;

    private Boolean raining;

    private Sensor sensor;

    public MeasurementDTO() {
    }

    public MeasurementDTO(Double airTemperature, Boolean raining) {
        this.airTemperature = airTemperature;
        this.raining = raining;
    }

    public MeasurementDTO(Double airTemperature, Boolean raining, Sensor sensor) {
        this.airTemperature = airTemperature;
        this.raining = raining;
        this.sensor = sensor;
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

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
