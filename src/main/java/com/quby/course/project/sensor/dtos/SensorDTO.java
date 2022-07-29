package com.quby.course.project.sensor.dtos;

import com.quby.course.project.sensor.models.Measurement;
import javax.validation.constraints.Size;
import java.util.List;

public class SensorDTO {
    @Size(min = 3, max = 30, message = "Sensor name should be between 3 and 30 characters")
    private String name;
    //private List<Measurement> meterage;

    public SensorDTO() {
    }

    public SensorDTO(String name) {
        this.name = name;
    }

    public SensorDTO(String name, List<Measurement> meterage) {
        this.name = name;
        //this.meterage = meterage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Measurement> getMeterage() {
//        return meterage;
//    }
//
//    public void setMeterage(List<Measurement> meterage) {
//        this.meterage = meterage;
//    }
}
