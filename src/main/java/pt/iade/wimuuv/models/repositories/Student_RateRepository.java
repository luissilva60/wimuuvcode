package pt.iade.wimuuv.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pt.iade.wimuuv.models.student_rate;


public interface Student_RateRepository extends CrudRepository<student_rate, Integer> {
    String resQuery1 = "select stu_rate_ev, org_name, event_name, spot_name, stu_id "
    + "from student_rate, org, event, spot, student " +
    "where event_id = 2 " +
    "order by stu_rate_ev DESC";

    @Query(value=resQuery1, nativeQuery=true)
    Iterable<String>getDescRateEv2();
    
}
