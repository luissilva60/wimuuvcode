package pt.iade.wimuuv.controllers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import pt.iade.wimuuv.models.event_spot_photo;
import pt.iade.wimuuv.models.exceptions.NotFoundException;
import pt.iade.wimuuv.models.exceptions.Response;
import pt.iade.wimuuv.models.repositories.Event_Spot_PhotoRepository;


@RestController
@RequestMapping(path = "/api/event_spot_photo")
public class Event_Spot_PhotoController {
    private final Logger logger = LoggerFactory.getLogger(Event_Spot_PhotoRepository.class);
    @Autowired
    private Event_Spot_PhotoRepository event_spot_photoRepository;
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<event_spot_photo> getevent_spot_photo()
    {
        logger.info("Sending all event_spot_photo!");
        return event_spot_photoRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public event_spot_photo getOrg(@PathVariable int id) {
        logger.info("Sending org with id " + id);
        Optional<event_spot_photo> event_spot_photo1 =   event_spot_photoRepository.findById(id);
        if (!event_spot_photo1.isPresent()) throw
                new NotFoundException("" + id, "event_spot_photo", "id");
        else
            return event_spot_photo1.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public event_spot_photo saveevent_spot_photo(@RequestBody event_spot_photo org) {
        event_spot_photo savedevent_spot_photo = event_spot_photoRepository.save(org);
        logger.info("Saving org with id " + savedevent_spot_photo.getId());
        return savedevent_spot_photo;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteevent_spot_photo(@PathVariable int id) {
        logger.info("Deleting Org with id " + id);
        Optional<event_spot_photo> event_spot_photo1 = event_spot_photoRepository.findById(id);
        if (!event_spot_photo1.isPresent()) throw
                new NotFoundException("" + id, "event_spot_photo", "id");
        else
            event_spot_photoRepository.deleteById(id);
            return new Response("Deleted org with id " + id, null);
    }
}
