package com.quby.course.project.sensor.utils;

import com.quby.course.project.sensor.exceptions.SensorNotRegisteredException;
import org.springframework.validation.BindingResult;

public class ErrorsResponseUtil {
    public static String returnErrorsToClient(BindingResult bindingResult) {
        StringBuilder errorMessage = new StringBuilder();
        bindingResult.getFieldErrors()
                .forEach(error -> errorMessage.append(error.getField())
                        .append(" - ")
                        .append(error.getDefaultMessage() == null ? error.getCode() : error.getDefaultMessage())
                        .append("\n"));
        return errorMessage.toString();
        //throw new SensorNotRegisteredException(errorMessage.toString());
    }
}
