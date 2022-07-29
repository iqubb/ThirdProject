package com.quby.course.project.sensor.utils;

import com.quby.course.project.sensor.models.Measurement;
import com.quby.course.project.sensor.models.Sensor;
import com.quby.course.project.sensor.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MeasurementValidator implements Validator {

    private final SensorService sensorService;

    @Autowired
    public MeasurementValidator(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Measurement.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Measurement measurement = (Measurement) target;
        if(!sensorService.getSensorByName(measurement.getSensor().getName()).isPresent()) {
            errors.rejectValue("sensor", "Sensor " + measurement.getSensor().getName() + "is not registered");
        }
    }
}
