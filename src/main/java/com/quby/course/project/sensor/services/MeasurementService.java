package com.quby.course.project.sensor.services;

import com.quby.course.project.sensor.models.Measurement;
import com.quby.course.project.sensor.repositories.MeasurementRepository;
import com.quby.course.project.sensor.repositories.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class MeasurementService {
    private final MeasurementRepository measurementRepository;

    private final SensorService sensorService;

    @Autowired
    public MeasurementService(MeasurementRepository measurementRepository, SensorService sensorService) {
        this.measurementRepository = measurementRepository;
        this.sensorService = sensorService;
    }

    @Transactional
    public void addMeasurement(Measurement measurement) {
        measurement.setSensor(sensorService.getSensorByName(measurement.getSensor().getName()).get());
        measurement.setMeasurementTime(new Timestamp(System.currentTimeMillis()));
        measurementRepository.save(measurement);
    }

    public List<Measurement> getMeterage() {
        return measurementRepository.findAll();
    }

    public Long getRainyDaysCount() {
        return getMeterage().stream()
                .filter(Measurement::getRaining)
                .count();
    }
}
