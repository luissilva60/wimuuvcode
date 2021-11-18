package pt.iade.wimuuv.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import pt.iade.wimuuv.models.student;
import pt.iade.wimuuv.models.exceptions.NotFoundException;
import pt.iade.wimuuv.models.exceptions.Response;
import pt.iade.wimuuv.models.repositories.StudentRepository;

@RestController
@RequestMapping(path = "/api/student")
public class StudentController {
    private final Logger logger = LoggerFactory.getLogger(StudentRepository.class);
    @Autowired
    private StudentRepository studentRepository;
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<student> getstudents()
    {
        logger.info("Sending all students!");
        return studentRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public student getStudent(@PathVariable int id_student) {
        logger.info("Sending student with id " + id_student);
        Optional<student> student1 =   studentRepository.findById(id_student);
        if (!student1.isPresent()) throw
                new NotFoundException("" + id_student, "Student", "id");
        else
            return student1.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public student saveStudent(@RequestBody student student) {
        student savedStudent = studentRepository.save(student);
        logger.info("Saving student with id " + savedStudent.getId());
        return savedStudent;
    }
    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteStudent(@PathVariable int id_student) {
        logger.info("Deleting student with id " + id_student);
        Optional<student> student1 = studentRepository.findById(id_student);
        if (!student1.isPresent()) throw
                new NotFoundException("" + id_student, "student", "id");
        else
            studentRepository.deleteById(id_student);
            return new Response("Deleted student with id " + id_student, null);
    }
}
