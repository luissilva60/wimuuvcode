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
    
    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public event getEvent(@PathVariable int id) {
        logger.info("Sending event with id " + id);
        Optional<event> event1 =   eventRepository.findById(id);
        if (!event1.isPresent()) throw
                new NotFoundException("" + id, "Event", "id");
        else
            return event1.get();
    }




    




    @PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response saveEvent(@RequestBody event eventId) {
        logger.info("Registering event with id " + eventId.getId() +
        " of course with id "+eventId.getName());
        Integer inserted = eventRepository.registerEvent(eventId);
        return new Response(inserted+" registration created",eventId);
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteEvent(@PathVariable int id) {
        logger.info("Deleting event with id " + id);
        Optional<event> event1 = eventRepository.findById(id);
        if (!event1.isPresent()) throw
                new NotFoundException("" + id, "event", "id");
        else
            eventRepository.deleteById(id);
            return new Response("Deleted event with id " + id, null);
    }

    


   @GetMapping(path = "/spot/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<event> findAllEventsinSpot(@PathVariable int id) {
        logger.info("Sending all events with spot id: " + id);
        return eventRepository.findAllEventsinSpot(id);
    }

    @GetMapping(path = "/org/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<event> getAllOrgEvents(@PathVariable int id) {
        logger.info("Sending all events with org id: " + id);
        return eventRepository.getAllOrgEvents(id);
    }
    @GetMapping(path = "/type/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<event> getAllTypeEvents(@PathVariable int id) {
        logger.info("Sending all events with type id: " + id);
        return eventRepository.getAllTypeEvents(id);
    }
   
    @GetMapping(path = "/spot/{spot_id:[0-9]+}/type/{type_id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<event> getAllTypeEventsinSpot(@PathVariable int type_id, @PathVariable int spot_id) {
        logger.info("Sending all events with type" + type_id + " in spot: "+ spot_id);
        return eventRepository.getAllTypeEventsinSpot(type_id, spot_id);
    }

    @GetMapping(path = "/historico/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<event> getHistorico(@PathVariable int id) {
        logger.info("Sending history with stu id: " + id);
        return eventRepository.getHistorico(id);
    }
}
