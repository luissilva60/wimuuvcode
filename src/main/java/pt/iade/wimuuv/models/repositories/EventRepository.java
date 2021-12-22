package pt.iade.wimuuv.models.repositories;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pt.iade.wimuuv.models.event;

public interface EventRepository extends CrudRepository<event, Integer> {
    
    
    
    
    @Modifying @Transactional
    @Query(value="insert into event (event_description, event_type_id, event_date, "+
        "event_starttime, event_endtime, event_duration, event_org_id, "+
        "event_spot_id, event_capacity, event_state_id, event_name, event_photos_id, event_rate_id)"+
        "values(:#{#event.description}, :#{#event.typeId}, "+
        " :#{#event.date}, :#{#event.starttime}, "+
        " :#{#event.endtime}, :#{#event.duration}, :#{#event.orgId},"+
        " :#{#event.spotId}, :#{#event.capacity}, :#{#event.stateId}, :#{#event.name}, :#{#event.photosId}, :#{#event.rateId})", nativeQuery=true)
    Integer registerEvent(@Param("event") event event);
    
    
    String evQuery2 = "select distinct event_name, org_name, spot_name, state_event "+
                "from event, org, spot, state "+
                "where state_id = 1";

    @Query(value=evQuery2, nativeQuery=true)
    Iterable<String>getEventState1();
    

    String evQuery3 = "select distinct event_name, event_date, event_starttime, "+
    "event_endtime, spot_name, type_event "+
    "from event, spot, type "+
    "where spot_id = 2 and type_id = 3 and event_spot_id = spot.spot_id";

    @Query(value=evQuery3, nativeQuery=true)
    Iterable<String>getEventPalestrainIade();
    
    
    
    
    String evQuery5 = "select distinct event_name, event_date, event_starttime,"+ 
    " event_duration, event_capacity, spot_name, org_name, type_event "+
    "from event, spot, org, type "+
    "where type_id = 2 and event_org_id = org.org_id and event_spot_id = "+
    "spot.spot_id and event_type_id = type.type_id";


    
    @Query(value=evQuery5, nativeQuery=true)
    Iterable<String>getEventtype2();


    @Query(value = "select * from event " + 
                "where event_spot_id = :id",
            nativeQuery = true)
    Iterable<event> findAllEventsinSpot(int id);
    
    
    @Query(value = "select * from event " + 
                "where event_org_id = :id",
            nativeQuery = true)
    Iterable<event> getAllOrgEvents(int id);
    

    @Query(value = "select * from event " + 
                "where event_type_id = :id",
            nativeQuery = true)
    Iterable<event> getAllTypeEvents(int id);

    @Query(value = "select * from event " + 
                "where event_type_id = :type_id AND event_spot_id = :spot_id",
            nativeQuery = true)
    Iterable<event> getAllTypeEventsinSpot(int type_id, int spot_id);

    @Query(value = "select * from event "+
    "inner join student_event se on event.event_id = se.ev_id " +
    "where stu_entry_id = :id",
    nativeQuery = true)
    Iterable<event> getHistorico(int id);
}
