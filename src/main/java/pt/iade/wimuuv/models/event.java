package pt.iade.wimuuv.models;



import java.sql.Time;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="event")
public class event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="event_id") private int id;
    @Column(name="event_name") private String name;
    @Column(name="event_description") private String description;
    @Column(name="event_type_id") private int typeId;
    @Column(name="event_date") private LocalDate date;
    @Column(name="event_starttime") private Time starttime;
    @Column(name="event_endtime") private Time endtime;
    @Column(name="event_duration") private Time duration;
    @Column(name="event_org_id") private int orgId;
    @Column(name="event_spot_id") private int spotId ;
    @Column(name="event_capacity") private int capacity;
    @Column(name="event_photos_id") private int photosId;
    @Column(name="event_state_id ") private int stateId ;
    @Column(name="event_rate_id ") private int rateId ;
    

    public int getCapacity() {
        return capacity;
    }
    public LocalDate getDate() {
        return date;
    }
    public String getDescription() {
        return description;
    }
    public Time getDuration() {
        return duration;
    }
    public Time getEndtime() {
        return endtime;
    }
    public int getId() {
        return id;
    }
    public int getOrgId() {
        return orgId;
    }
    
    public int getSpotId() {
        return spotId;
    }
    public Time getStarttime() {
        return starttime;
    }
    public int getStateId() {
        return stateId;
    }
    public int getTypeId() {
        return typeId;
    }
    public String getName() {
        return name;
    }
    public int getPhotosId() {
        return photosId;
    }
    public int getRateId() {
        return rateId;
    }
    
    
}
