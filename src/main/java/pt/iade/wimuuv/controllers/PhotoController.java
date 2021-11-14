package pt.iade.wimuuv.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import pt.iade.wimuuv.models.photo;
import pt.iade.wimuuv.models.exceptions.NotFoundException;
import pt.iade.wimuuv.models.exceptions.Response;
import pt.iade.wimuuv.models.repositories.PhotoRepository;

@RestController
@RequestMapping(path = "/api/photo")
public class PhotoController {
    private final Logger logger = LoggerFactory.getLogger(PhotoRepository.class);
    @Autowired
    private PhotoRepository photoRepository;
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<photo> getPhotos()
     {
        logger.info("Sending all photos!");
        return photoRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public photo getPhoto(@PathVariable int id_photo) {
        logger.info("Sending photo with id " + id_photo);
        Optional<photo> photo1 =   photoRepository.findById(id_photo);
        if (!photo1.isPresent()) throw
                new NotFoundException("" + id_photo, "Photo", "id");
        else
            return photo1.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public photo savePhoto(@RequestBody photo photo) {
        photo savedPhoto = photoRepository.save(photo);
        logger.info("Saving photo with id " + savedPhoto.getPhoto_id());
        return savedPhoto;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deletePhoto(@PathVariable int id_photo) {
        logger.info("Deleting photo with id " + id_photo);
        Optional<photo> photo1 = photoRepository.findById(id_photo);
        if (!photo1.isPresent()) throw
                new NotFoundException("" + id_photo, "photo", "id");
        else
            photoRepository.deleteById(id_photo);
            return new Response("Deleted photo with id " + id_photo, null);
    }
}
