package pt.iade.wimuuv.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import pt.iade.wimuuv.models.student_event_photo;
import pt.iade.wimuuv.models.exceptions.NotFoundException;
import pt.iade.wimuuv.models.exceptions.Response;
import pt.iade.wimuuv.models.repositories.Student_Event_PhotoRepository;


@RestController
@RequestMapping(path = "/api/student_event_photo")
public class Student_Event_PhotoController {

    private final Logger logger = LoggerFactory.getLogger(Student_Event_PhotoRepository.class);
    @Autowired
    private Student_Event_PhotoRepository student_event_photoRepository;
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<student_event_photo> getstudent_event_photo()
    {
        logger.info("Sending all student event photos!");
        return student_event_photoRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public student_event_photo getstudent_event_photo(@PathVariable int id) {
        logger.info("Sending student_event_photo with id " + id);
        Optional<student_event_photo> student_event_photo1 =   student_event_photoRepository.findById(id);
        if (!student_event_photo1.isPresent()) throw
                new NotFoundException("" + id, "student_event_photo", "id");
        else
            return student_event_photo1.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public student_event_photo savestudent_event_photo(@RequestBody student_event_photo student_event_photo) {
        student_event_photo savedstudent_event_photo = student_event_photoRepository.save(student_event_photo);
        logger.info("Saving student_event_photo with id " + savedstudent_event_photo.getEv_photo_id());
        return savedstudent_event_photo;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deletestudent_event_photo(@PathVariable int id) {
        logger.info("Deleting student_event_photo with id " + id);
        Optional<student_event_photo> student_event_photo1 = student_event_photoRepository.findById(id);
        if (!student_event_photo1.isPresent()) throw
                new NotFoundException("" + id, "student_event_photo", "id");
        else
            student_event_photoRepository.deleteById(id);
            return new Response("Deleted student_event_photo with id " + id, null);
    }

    
}
