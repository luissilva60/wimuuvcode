package pt.iade.wimuuv.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
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

    @PostMapping(path = "/{name}/{email}/{password}/{bdate}/{gender}/{course_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<student> findAllEventsinSpot(@PathVariable String name, String email, String password, Date bdate, char gender, int course_id ) {
    
        return studentRepository.SignupStudent(name, email,password, bdate, gender,course_id );
    }

    @PutMapping(path = "/{id}/changepw/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response ChangePasswordStudent(@PathVariable String password,
                                        @PathVariable int id) {
        if(studentRepository.findById(id).isPresent()){
            Iterable<student> updated = studentRepository.ChangePasswordStudent(password, id);

            return new Response(updated +"Updated student with id : "+ id, password);
        }else{
            return null;
        }
        
    
    }

    @GetMapping(path = "/{id:[0-9]+}/historico", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<student> getHistorico(@PathVariable int id) {
        logger.info("Sending history with stu id: " + id);
        return studentRepository.getHistorico(id);
    }
    

}
