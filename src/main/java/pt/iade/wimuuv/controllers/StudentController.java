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
    public student getStudent(@PathVariable int id) {
        logger.info("Sending student with id " + id);
        Optional<student> _student =   studentRepository.findById(id);
        if (!_student.isPresent()) throw
                new NotFoundException("" + id, "Student", "id");
        else
            return _student.get();
    }

    /*@PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public student saveStudent(@RequestBody student student) {
        student savedStudent = studentRepository.save(student);
        logger.info("Saving student with id " + savedStudent.getId());
        return savedStudent;
    }*/
    @PostMapping(path = "/new", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response saveStudent(@RequestBody student studentId) {
        logger.info("Registering student with id " + studentId.getId() +
        " of course with id "+studentId.getCrseId());
        Integer inserted = studentRepository.registerStudent(studentId);
    return new Response(inserted+" registration created",studentId);
}
    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteStudent(@PathVariable int id) {
        logger.info("Deleting student with id " + id);
        Optional<student> student1 = studentRepository.findById(id);
        if (!student1.isPresent()) throw
                new NotFoundException("" + id, "student", "id");
        else
            studentRepository.deleteById(id);
            return new Response("Deleted student with id " + id, null);
    }
}
