package pt.iade.wimuuv.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pt.iade.wimuuv.models.student_event;


public interface Student_EventRepository extends CrudRepository<student_event, Integer> {
    @Query(value = "select * from event "+
    "inner join student_event se on event.event_id = se.ev_id " +
    "where stu_entry_id = :id",
    nativeQuery = true)
    Iterable<student_event> gethistorico(int id);
}
