package pt.iade.wimuuv.models.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pt.iade.wimuuv.models.student_event;


public interface Student_EventRepository extends CrudRepository<student_event, Integer> {
    @Query(value = "select * from event "+
    "inner join student_event se on event.event_id = se.ev_id " +
    "where stu_entry_id = :id",
    nativeQuery = true)
    Iterable<student_event> gethistorico(int id);

    @Modifying @Transactional
    @Query(value="insert into student_rate(stu_entry_id, stu_ev_entrytime, ev_id ) "+
        "values( :#{#student_event.entryId}, :#{#student_event.evEntrytime}, "+
        " :#{#student_event.evId})", nativeQuery=true)
    Integer registerStudentEvent(@Param("student_event") student_event student_event);
}
