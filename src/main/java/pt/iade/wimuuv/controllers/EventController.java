package pt.iade.wimuuv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import antlr.debug.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pt.iade.wimuuv.models.event;
import pt.iade.wimuuv.models.repositories.EventRepository;


@RestController
@RequestMapping(path = "/api/events")
public class EventController {
    private final Logger logger = LoggerFactory.getLogger(EventRepository.class);
    @Autowired
    private EventRepository eventRepository;
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<event> getEvents()
     {
        logger.info("Sending all events!");
        return eventRepository.findAll();
    }
}
