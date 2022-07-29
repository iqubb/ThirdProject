package com.quby.course.project.sensor.controllers;

import com.quby.course.project.sensor.dtos.MeasurementDTO;
import com.quby.course.project.sensor.exceptions.MeasurementNotAddException;
import com.quby.course.project.sensor.models.Measurement;
import com.quby.course.project.sensor.services.MeasurementService;
import com.quby.course.project.sensor.utils.MeasurementErrorResponse;
import com.quby.course.project.sensor.utils.MeasurementValidator;
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
public class MeasurementController {

    private final MeasurementService measurementService;
    private final ModelMapper modelMapper;
    private final MeasurementValidator measurementValidator;

    @Autowired
    public MeasurementController(MeasurementService measurementService, ModelMapper modelMapper, MeasurementValidator measurementValidator) {
        this.measurementService = measurementService;
        this.modelMapper = modelMapper;
        this.measurementValidator = measurementValidator;
    }

    @GetMapping("/meterage")
    public List<MeasurementDTO> getMeterage() {
        //TODO ONE TYPE TO RESPONSE
        return measurementService.getMeterage()
                .stream()
                .map(this::convertToMeasurementDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/meterage/rainyDaysCount")
    public Long getRainyDaysCount() {
        return measurementService.getRainyDaysCount();
    }

    @PostMapping("/meterage")
    public ResponseEntity<HttpStatus> addMeasurement(@RequestBody @Valid MeasurementDTO measurementDTO, BindingResult bindingResult) {
        measurementValidator.validate(convertToMeasurement(measurementDTO), bindingResult);
        if(bindingResult.hasErrors()) {
            throw new MeasurementNotAddException(returnErrorsToClient(bindingResult));
        }
        measurementService.addMeasurement(convertToMeasurement(measurementDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<MeasurementErrorResponse> handleException(MeasurementNotAddException exception) {
        MeasurementErrorResponse response = new MeasurementErrorResponse(
                exception.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private Measurement convertToMeasurement(MeasurementDTO measurementDTO) {
        return modelMapper.map(measurementDTO, Measurement.class);
    }

    private MeasurementDTO convertToMeasurementDTO(Measurement measurement) {
        return modelMapper.map(measurement, MeasurementDTO.class);
    }
}
