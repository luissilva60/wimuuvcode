package pt.iade.wimuuv.models.repositories;

import org.springframework.data.repository.CrudRepository;

import pt.iade.wimuuv.models.student;

public interface StudentRepository extends CrudRepository<student, Integer>{
    
}
