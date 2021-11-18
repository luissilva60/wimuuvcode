package pt.iade.wimuuv.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import pt.iade.wimuuv.models.student_course;
import pt.iade.wimuuv.models.exceptions.NotFoundException;
import pt.iade.wimuuv.models.exceptions.Response;
import pt.iade.wimuuv.models.repositories.Student_courseRepository;

@RestController
@RequestMapping(path = "/api/student_course")
public class Student_CourseController {
    private final Logger logger = LoggerFactory.getLogger(Student_courseRepository.class);
    @Autowired
    private Student_courseRepository student_courseRepository;
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<student_course> getRates()
    {
        logger.info("Sending all student_courses!");
        return student_courseRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public student_course getStudent_course(@PathVariable int id) {
        logger.info("Sending student_course with id " + id);
        Optional<student_course> student_course1 =   student_courseRepository.findById(id);
        if (!student_course1.isPresent()) throw
                new NotFoundException("" + id, "Student_course", "id");
        else
            return student_course1.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public student_course saveStudent_course(@RequestBody student_course student_course) {
        student_course savedStudent_course = student_courseRepository.save(student_course);
        logger.info("Saving student_course with id " + savedStudent_course.getStu_course_id());
        return savedStudent_course;
    }
    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteStudent_course(@PathVariable int id) {
        logger.info("Deleting student_course with id " + id);
        Optional<student_course> student_course1 = student_courseRepository.findById(id);
        if (!student_course1.isPresent()) throw
                new NotFoundException("" + id, "student_course", "id");
        else
            student_courseRepository.deleteById(id);
            return new Response("Deleted student_course with id " + id, null);
    }
}
