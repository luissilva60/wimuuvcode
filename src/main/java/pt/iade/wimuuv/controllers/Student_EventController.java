package pt.iade.wimuuv.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import pt.iade.wimuuv.models.student_event;
import pt.iade.wimuuv.models.exceptions.NotFoundException;
import pt.iade.wimuuv.models.exceptions.Response;
import pt.iade.wimuuv.models.repositories.Student_EventRepository;


@RestController
@RequestMapping(path = "/api/student_event")


public class Student_EventController {
    private final Logger logger = LoggerFactory.getLogger(Student_EventRepository.class);
    @Autowired
    private Student_EventRepository student_eventRepository;
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<student_event> getstudent_event()
    {
        logger.info("Sending all student_event!");
        return student_eventRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public student_event getOrg(@PathVariable int id_student_event) {
        logger.info("Sending org with id " + id_student_event);
        Optional<student_event> student_event1 =   student_eventRepository.findById(id_student_event);
        if (!student_event1.isPresent()) throw
                new NotFoundException("" + id_student_event, "student_event", "id");
        else
            return student_event1.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public student_event savestudent_event(@RequestBody student_event org) {
        student_event savedstudent_event = student_eventRepository.save(org);
        logger.info("Saving org with id " + savedstudent_event.getStu_ev_id());
        return savedstudent_event;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deletestudent_event(@PathVariable int id_student_event) {
        logger.info("Deleting Org with id " + id_student_event);
        Optional<student_event> student_event1 = student_eventRepository.findById(id_student_event);
        if (!student_event1.isPresent()) throw
                new NotFoundException("" + id_student_event, "student_event", "id");
        else
            student_eventRepository.deleteById(id_student_event);
            return new Response("Deleted org with id " + id_student_event, null);
    }

}
