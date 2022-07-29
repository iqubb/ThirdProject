package com.quby.course.project.sensor.services;

import com.quby.course.project.sensor.exceptions.SensorNotFoundException;
import com.quby.course.project.sensor.models.Sensor;
import com.quby.course.project.sensor.repositories.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SensorService {

    private final SensorRepository sensorRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Transactional
    public void addSensor(Sensor sensor) {
        sensorRepository.save(sensor);
    }

    public Optional<Sensor> getSensorByName(String name) {
        return sensorRepository.findSensorByName(name);
        //Optional<Sensor> sensorOptional = sensorRepository.findSensorByName(name);
        //return sensorOptional.orElseThrow(() -> new SensorNotFoundException("Sensor " + name + " not found"));
    }

    public List<Sensor> getSensors() {
        return sensorRepository.findAll();
    }
}
