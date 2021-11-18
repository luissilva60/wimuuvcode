package pt.iade.wimuuv.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import pt.iade.wimuuv.models.orgs;
import pt.iade.wimuuv.models.exceptions.NotFoundException;
import pt.iade.wimuuv.models.exceptions.Response;
import pt.iade.wimuuv.models.repositories.OrgsRepository;


@RestController
@RequestMapping(path = "/api/orgs")
public class OrgsController {
    private final Logger logger = LoggerFactory.getLogger(OrgsRepository.class);
    @Autowired
    private OrgsRepository orgsRepository;
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<orgs> getOrgs()
    {
        logger.info("Sending all orgs!");
        return orgsRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public orgs getOrg(@PathVariable int id) {
        logger.info("Sending org with id " + id);
        Optional<orgs> orgs1 =   orgsRepository.findById(id);
        if (!orgs1.isPresent()) throw
                new NotFoundException("" + id, "Orgs", "id");
        else
            return orgs1.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public orgs saveOrgs(@RequestBody orgs org) {
        orgs savedOrgs = orgsRepository.save(org);
        logger.info("Saving org with id " + savedOrgs.getOrg_id());
        return savedOrgs;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteOrgs(@PathVariable int id) {
        logger.info("Deleting Org with id " + id);
        Optional<orgs> orgs1 = orgsRepository.findById(id);
        if (!orgs1.isPresent()) throw
                new NotFoundException("" + id, "orgs", "id");
        else
            orgsRepository.deleteById(id);
            return new Response("Deleted org with id " + id, null);
    }



}
