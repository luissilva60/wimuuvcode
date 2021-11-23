package pt.iade.wimuuv.models.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pt.iade.wimuuv.models.event;

public interface EventRepository extends CrudRepository<event, Integer> {
    String resQuery1 = "select event_name, spot_name "+
                "from event, spot " + "where event_org_id = 1";

    @Query(value=resQuery1, nativeQuery=true)
    Iterable<String>getEventOrgId1();
    
    String resQuery2 = "select event_name, org_name, spot_name, state_event "+
                "from event, org, spot, state "+
                "where state_id = 1";

    @Query(value=resQuery2, nativeQuery=true)
    Iterable<String>getEventState1();
    

    String resQuery3 = "select event_name, event_date, event_starttime,"+
    " event_endtime, spot_name, org_name, type_event "+
    "from event, spot, org, type "+
    "where spot_id = 2 and type_id = 1";

    @Query(value=resQuery3, nativeQuery=true)
    Iterable<String>getEventPalestrainIade();
    
    
    String resQuery4 = "select event_name, event_date, event_starttime,"+
    " event_duration, spot_name, org_name "+
    "from event, spot, org "+
    "where event_org_id = 2";

    @Query(value=resQuery4, nativeQuery=true)
    Iterable<String>getEventOrg2();
    
    
    String resQuery5 = "select event_name, event_date, event_starttime,"+ 
    " event_duration, event_capacity, spot_name, org_name, type_event "+
    "from event, spot, org, type "+
    "where type_id = 2";

    @Query(value=resQuery5, nativeQuery=true)
    Iterable<String>getEventtype2();

    
    
}
