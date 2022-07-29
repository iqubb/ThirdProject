package com.quby.course.project.sensor.controllers;

import com.quby.course.project.sensor.dtos.SensorDTO;
import com.quby.course.project.sensor.models.Sensor;
import com.quby.course.project.sensor.services.SensorService;
import com.quby.course.project.sensor.exceptions.SensorNotRegisteredException;
import com.quby.course.project.sensor.utils.ErrorsResponseUtil;
import com.quby.course.project.sensor.utils.SensorErrorResponse;
import com.quby.course.project.sensor.utils.SensorValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static com.quby.course.project.sensor.utils.ErrorsResponseUtil.returnErrorsToClient;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SensorController {

    private final SensorService sensorService;
    private final ModelMapper modelMapper;
    private final SensorValidator sensorValidator;


    @Autowired
    public SensorController(SensorService sensorService, ModelMapper modelMapper, SensorValidator sensorValidator) {
        this.sensorService = sensorService;
        this.modelMapper = modelMapper;
        this.sensorValidator = sensorValidator;
    }

    @GetMapping("/sensors")
    public List<SensorDTO> getSensors() {
        return sensorService.getSensors()
                .stream()
                .map(this::convertToSensorDTO)
                .collect(Collectors.toList());
    }


    @PostMapping("/sensors")
    public ResponseEntity<HttpStatus> registerSensor(@RequestBody @Valid SensorDTO sensorDTO, BindingResult bindingResult) {
        sensorValidator.validate(convertToSensor(sensorDTO), bindingResult);
        if(bindingResult.hasErrors()) {
            throw new SensorNotRegisteredException(returnErrorsToClient(bindingResult));
        }
        sensorService.addSensor(convertToSensor(sensorDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<SensorErrorResponse> handleException(SensorNotRegisteredException exception) {
        SensorErrorResponse response = new SensorErrorResponse(
                exception.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private Sensor convertToSensor(SensorDTO sensorDTO) {
        return modelMapper.map(sensorDTO, Sensor.class);
    }

    private SensorDTO convertToSensorDTO(Sensor sensor) {
        return modelMapper.map(sensor, SensorDTO.class);
    }
}
