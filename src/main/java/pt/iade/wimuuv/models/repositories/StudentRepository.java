package pt.iade.wimuuv.models.repositories;



import java.sql.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pt.iade.wimuuv.models.student;

public interface StudentRepository extends CrudRepository<student, Integer>{
    @Modifying @Transactional
    @Query(value="insert into student (stu_name, stu_email, stu_password,"+
        "stu_bdate, stu_gender, stu_crse_id)"+
        "values(:#{#student.name}, :#{#student.email}, "+
        ":#{#student.password}, :#{#student.bdate}"+
        ", :#{#student.gender}, :#{#student.crseId} )", nativeQuery=true)
    Integer registerStudent(@Param("student") student student);
    

    @Query(value = "insert into student (stu_name, stu_email, stu_password,"+
        "stu_bdate, stu_gender, stu_crse_id)"+
        "values(:name, :email, "+
        ":password, :bdate"+
        ", :gender, :course_id )", nativeQuery=true)
    Iterable<student> SignupStudent(String name, String email, String password, Date bdate, char gender, int course_id );

                        
    @Query(value = "UPDATE student " + 
    "SET stu_password = ':password' "+
    "WHERE stu_id = :id",
    nativeQuery = true)
    Iterable<student> ChangePasswordStudent(@Param ("password") String password, 
                                            @Param("id") int id);
}
