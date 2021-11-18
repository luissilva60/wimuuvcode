package pt.iade.wimuuv.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


import pt.iade.wimuuv.models.type;
import pt.iade.wimuuv.models.exceptions.NotFoundException;
import pt.iade.wimuuv.models.exceptions.Response;
import pt.iade.wimuuv.models.repositories.TypeRepository;

@RestController
@RequestMapping(path = "/api/type")
public class TypeController {
    private final Logger logger = LoggerFactory.getLogger(TypeRepository.class);
    @Autowired
    private TypeRepository typeRepository;
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<type> getETypes()
    {
        logger.info("Sending all types!");
        return typeRepository.findAll();
    }
    
    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public type getType(@PathVariable int id) {
        logger.info("Sending type with id " + id);
        Optional<type> type1 =   typeRepository.findById(id);
        if (!type1.isPresent()) throw
                new NotFoundException("" + id, "Type", "id");
        else
            return type1.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public type saveType(@RequestBody type type) {
        type savedType = typeRepository.save(type);
        logger.info("Saving type with id " + savedType.getId());
        return savedType;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteType(@PathVariable int id) {
        logger.info("Deleting type with id " + id);
        Optional<type> type1 = typeRepository.findById(id);
        if (!type1.isPresent()) throw
                new NotFoundException("" + id, "type", "id");
        else
            typeRepository.deleteById(id);
            return new Response("Deleted type with id " + id, null);
    }
}
