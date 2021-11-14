package pt.iade.wimuuv.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import pt.iade.wimuuv.models.state;
import pt.iade.wimuuv.models.exceptions.NotFoundException;
import pt.iade.wimuuv.models.exceptions.Response;
import pt.iade.wimuuv.models.repositories.StateRepository;

@RestController
@RequestMapping(path = "/api/state")
public class StateController {
    private final Logger logger = LoggerFactory.getLogger(StateRepository.class);
    @Autowired
    private StateRepository stateRepository;
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<state> getStates()
    {
        logger.info("Sending all states!");
        return stateRepository.findAll();
    }
    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public state getState(@PathVariable int id_state) {
        logger.info("Sending state with id " + id_state);
        Optional<state> state1 =   stateRepository.findById(id_state);
        if (!state1.isPresent()) throw
                new NotFoundException("" + id_state, "State", "id");
        else
            return state1.get();
    }
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public state saveState(@RequestBody state state) {
        state savedState = stateRepository.save(state);
        logger.info("Saving state with id " + savedState.getState_id());
        return savedState;
    }
    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteState(@PathVariable int id_state) {
        logger.info("Deleting state with id " + id_state);
        Optional<state> state1 = stateRepository.findById(id_state);
        if (!state1.isPresent()) throw
                new NotFoundException("" + id_state, "state", "id");
        else
            stateRepository.deleteById(id_state);
            return new Response("Deleted state with id " + id_state, null);
    }
}
