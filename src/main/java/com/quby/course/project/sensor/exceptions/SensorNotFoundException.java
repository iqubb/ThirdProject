package com.quby.course.project.sensor.exceptions;

public class SensorNotFoundException extends RuntimeException{
    public SensorNotFoundException(String message) {
        super(message);
    }
}
