package com.quby.course.project.sensor.utils;

public class MeasurementErrorResponse {
    private String errorMessage;
    private Long timestamp;

    public MeasurementErrorResponse(String errorMessage, Long timestamp) {
        this.errorMessage = errorMessage;
        this.timestamp = timestamp;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
