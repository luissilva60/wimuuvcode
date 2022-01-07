package pt.iade.wimuuv.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


import pt.iade.wimuuv.models.spot;
import pt.iade.wimuuv.models.exceptions.NotFoundException;
import pt.iade.wimuuv.models.exceptions.Response;
import pt.iade.wimuuv.models.repositories.SpotRepository;


@RestController
@RequestMapping(path = "/api/spots")
public class SpotController {
    private final Logger logger = LoggerFactory.getLogger(SpotRepository.class);
    @Autowired
    private SpotRepository spotRepository;
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<spot> getRates()
    {
        logger.info("Sending all spots!");
        return spotRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public spot getSpot(@PathVariable int id) {
        logger.info("Sending spot with id " + id);
        Optional<spot> spot1 =   spotRepository.findById(id);
        if (!spot1.isPresent()) throw
                new NotFoundException("" + id, "Spot", "id");
        else
            return spot1.get();
    }
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public spot saveSpot(@RequestBody spot spot) {
        spot savedSpot = spotRepository.save(spot);
        logger.info("Saving spot with id " + savedSpot.getId());
        return savedSpot;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteSpot(@PathVariable int id) {
        logger.info("Deleting spot with id " + id);
        Optional<spot> spot1 = spotRepository.findById(id);
        if (!spot1.isPresent()) throw
                new NotFoundException("" + id, "spot", "id");
        else
            spotRepository.deleteById(id);
            return new Response("Deleted spot with id " + id, null);
    }
    
}
