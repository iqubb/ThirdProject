//package com.quby.course.project.sensor.controllers;
//
//import com.quby.course.project.sensor.exceptions.PersonNotFoundException;
//import com.quby.course.project.sensor.models.Person;
//import com.quby.course.project.sensor.services.PeopleService;
//import com.quby.course.project.sensor.utils.PersonErrorResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController("/api/people")
//public class PersonController {
//
//    private final PeopleService peopleService;
//
//    @Autowired
//    public PersonController(PeopleService peopleService) {
//        this.peopleService = peopleService;
//    }
//
//
//    @GetMapping
//    public List<Person> getPeopleList() {
//        return peopleService.getPeopleList();
//    }
//
//    @GetMapping("/{id}")
//    public Person getPerson(@PathVariable("id") Integer id) {
//        return peopleService.getPersonById(id);
//    }
//
//    @PostMapping
//    public void addPerson(@RequestBody Person person) {
//        peopleService.addPerson(person);
//    }
//
//    @PutMapping("/{id}")
//    public void updatePerson(@PathVariable("id") Integer id, @RequestBody Person updatedPerson) {
//        peopleService.updatePerson(id, updatedPerson);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deletePerson(@PathVariable("id") Integer id) {
//        peopleService.deletePerson(id);
//    }
//
//    @ExceptionHandler
//    private ResponseEntity<PersonErrorResponse> handleException(PersonNotFoundException exception) {
//        PersonErrorResponse response = new PersonErrorResponse(
//                "Person with this id wasn't found",
//                System.currentTimeMillis()
//        );
//        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
//    }
//}
