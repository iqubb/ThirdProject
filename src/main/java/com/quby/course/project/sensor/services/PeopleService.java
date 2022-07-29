//package com.quby.course.project.sensor.services;
//
//import com.quby.course.project.sensor.exceptions.PersonNotFoundException;
//import com.quby.course.project.sensor.models.Person;
//import com.quby.course.project.sensor.repositories.PeopleRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@Transactional(readOnly = true)
//public class PeopleService {
//    private final PeopleRepository peopleRepository;
//
//    @Autowired
//    public PeopleService(PeopleRepository peopleRepository) {
//        this.peopleRepository = peopleRepository;
//    }
//
//    public List<Person> getPeopleList() {
//        return peopleRepository.findAll();
//    }
//
//    public Person getPersonById(Integer id) {
//        Optional<Person> personOptional = peopleRepository.findById(id);
//        return personOptional.orElseThrow(PersonNotFoundException::new);
//    }
//
//    @Transactional
//    public void addPerson(Person person) {
//        peopleRepository.save(person);
//    }
//
//    @Transactional
//    public void updatePerson(Integer id, Person updatedPerson) {
//        updatedPerson.setId(id);
//        addPerson(updatedPerson);
//    }
//    //TODO check is person with this name already exist
//
//    @Transactional
//    public void deletePerson(Integer id) {
//        if(peopleRepository.findById(id).isEmpty()) {
//            throw new PersonNotFoundException();
//        }
//        peopleRepository.deleteById(id);
//    }
//}
