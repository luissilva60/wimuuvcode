package pt.iade.wimuuv.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import pt.iade.wimuuv.models.event;
import pt.iade.wimuuv.models.exceptions.NotFoundException;
import pt.iade.wimuuv.models.exceptions.Response;
import pt.iade.wimuuv.models.repositories.EventRepository;


@RestController
@RequestMapping(path = "/api/event")
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
    
    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public event getEvent(@PathVariable int id_event) {
        logger.info("Sending event with id " + id_event);
        Optional<event> event1 =   eventRepository.findById(id_event);
        if (!event1.isPresent()) throw
                new NotFoundException("" + id_event, "Event", "id");
        else
            return event1.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public event saveEvent(@RequestBody event event) {
        event savedEvent = eventRepository.save(event);
        logger.info("Saving event with id " + savedEvent.getEvent_id());
        return savedEvent;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteEvent(@PathVariable int id_event) {
        logger.info("Deleting event with id " + id_event);
        Optional<event> event1 = eventRepository.findById(id_event);
        if (!event1.isPresent()) throw
                new NotFoundException("" + id_event, "event", "id");
        else
            eventRepository.deleteById(id_event);
            return new Response("Deleted event with id " + id_event, null);
    }

}
