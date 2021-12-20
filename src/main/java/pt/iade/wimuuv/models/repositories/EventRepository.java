package pt.iade.wimuuv.models.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pt.iade.wimuuv.models.event;

public interface EventRepository extends CrudRepository<event, Integer> {
    
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
    
}
