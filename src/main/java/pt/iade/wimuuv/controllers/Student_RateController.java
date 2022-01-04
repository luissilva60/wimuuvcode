package pt.iade.wimuuv.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import pt.iade.wimuuv.models.student_rate;
import pt.iade.wimuuv.models.exceptions.NotFoundException;
import pt.iade.wimuuv.models.exceptions.Response;
import pt.iade.wimuuv.models.repositories.Student_RateRepository;


@RestController
@RequestMapping(path = "/api/student_rate")
public class Student_RateController {
    private final Logger logger = LoggerFactory.getLogger(Student_RateRepository.class);
    @Autowired
    private Student_RateRepository student_rateRepository;
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<student_rate> getstudent_rate()
    {
        logger.info("Sending all student_rate!");
        return student_rateRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public student_rate getOrg(@PathVariable int id) {
        logger.info("Sending org with id " + id);
        Optional<student_rate> student_rate1 =   student_rateRepository.findById(id);
        if (!student_rate1.isPresent()) throw
                new NotFoundException("" + id, "student_rate", "id");
        else
            return student_rate1.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public student_rate savestudent_rate(@RequestBody student_rate org) {
        student_rate savedstudent_rate = student_rateRepository.save(org);
        logger.info("Saving org with id " + savedstudent_rate.getId());
        return savedstudent_rate;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deletestudent_rate(@PathVariable int id) {
        logger.info("Deleting Org with id " + id);
        Optional<student_rate> student_rate1 = student_rateRepository.findById(id);
        if (!student_rate1.isPresent()) throw
                new NotFoundException("" + id, "student_rate", "id");
        else
            student_rateRepository.deleteById(id);
            return new Response("Deleted org with id " + id, null);
    }

    @GetMapping(path = "/event", produces= MediaType.APPLICATION_JSON_VALUE)
        public Iterable<String> getDescRateEv2() {
        return student_rateRepository.getDescRateEv2();
   }

   @PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response saveEvent(@RequestBody student_rate rate) {
        logger.info("Registering rate with id " + rate.getId());
        Integer inserted = student_rateRepository.registerRate(rate);
        return new Response(inserted+" registration created",rate);
    }

   

}
