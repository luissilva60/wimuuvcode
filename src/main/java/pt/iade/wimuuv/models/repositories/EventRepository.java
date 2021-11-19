package pt.iade.wimuuv.models.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pt.iade.wimuuv.models.event;

public interface EventRepository extends CrudRepository<event, Integer> {
    String resQuery1 = "select event_name, spot_name "+
                "from event, spot " + "where org_id = 1";

    @Query(value=resQuery1, nativeQuery=true)
    Iterable<String>getEventOrgId1();
    
    String resQuery2 = "select event_name, org_name, spot_name, state_event "+
                "from event, org, spot, state "+
                "where state_id = 1";

    @Query(value=resQuery2, nativeQuery=true)
    Iterable<String>getEventState1();
    
    
}
