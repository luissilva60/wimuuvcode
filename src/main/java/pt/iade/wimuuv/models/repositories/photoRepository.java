package pt.iade.wimuuv.models.repositories;

import org.springframework.data.repository.CrudRepository;

import pt.iade.wimuuv.models.photo;

public interface PhotoRepository extends CrudRepository<photo, Integer> {
    
}
