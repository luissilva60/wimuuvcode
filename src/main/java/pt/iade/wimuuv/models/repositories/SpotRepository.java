package pt.iade.wimuuv.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pt.iade.wimuuv.models.spot;

public interface SpotRepository extends CrudRepository<spot, Integer>{
    @Query(value = "select * from spot inner join spot s on event.event_spot_id = s.spot_id where event_spot_id = :id",
            nativeQuery = true)
    Iterable<spot> findAllEventsinSpot(int id);
}
