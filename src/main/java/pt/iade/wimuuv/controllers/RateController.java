package pt.iade.wimuuv.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import pt.iade.wimuuv.models.rate;
import pt.iade.wimuuv.models.exceptions.NotFoundException;
import pt.iade.wimuuv.models.exceptions.Response;
import pt.iade.wimuuv.models.repositories.RateRepository;


@RestController
@RequestMapping(path = "/api/rate")
public class RateController {
    private final Logger logger = LoggerFactory.getLogger(RateRepository.class);
    @Autowired
    private RateRepository rateRepository;
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<rate> getrates()
    {
        logger.info("Sending all rates!");
        return rateRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public rate getRate(@PathVariable int id) {
        logger.info("Sending rate with id " + id);
        Optional<rate> rate1 =   rateRepository.findById(id);
        if (!rate1.isPresent()) throw
                new NotFoundException("" + id, "Rate", "id");
        else
            return rate1.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public rate saveRate(@RequestBody rate rate) {
        rate savedRate = rateRepository.save(rate);
        logger.info("Saving rate with id " + savedRate.getRate_id());
        return savedRate;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteRate(@PathVariable int id) {
        logger.info("Deleting rate with id " + id);
        Optional<rate> rate1 = rateRepository.findById(id);
        if (!rate1.isPresent()) throw
                new NotFoundException("" + id, "rate", "id");
        else
            rateRepository.deleteById(id);
            return new Response("Deleted rate with id " + id, null);
    }

}
