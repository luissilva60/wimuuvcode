package pt.iade.wimuuv.models.repositories;



import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pt.iade.wimuuv.models.student;

public interface StudentRepository extends CrudRepository<student, Integer>{
    @Modifying @Transactional
    @Query(value="insert into student (stu_name,stu_email, stu_photo_id,stu_password,"+
        "stu_bdate,stu_gender,stu_crse_id)"+
        "values(:#{#student.name}, :#{#student.email}, :#{#student.photoId}, "+
        ":#{#student.password}, :#{#student.bdate}"+
        ", :#{#student.gender}, :#{#student.crseId} )", nativeQuery=true)
    Integer registerStudent(@Param("student") student student);
                        
}
