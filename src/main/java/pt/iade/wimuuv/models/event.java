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
    @Column(name="event_name") private String event_name;
    @Column(name="event_description") private String event_description;
    @Column(name="event_type_id") private int event_type_id;
    @Column(name="event_date") private LocalDate event_date;
    @Column(name="event_starttime") private Time event_starttime;
    @Column(name="event_endtime") private Time event_endtime;
    @Column(name="event_duration") private Time event_duration;
    @Column(name="event_org_id") private int event_org_id;
    @Column(name="event_spot_id") private int event_spot_id ;
    @Column(name="event_capacity") private int event_capacity;
    @Column(name="event_photos_id") private int event_photos_id;
    @Column(name="event_state_id ") private String event_state_id ;
    @Column(name="event_rate_id ") private int event_rate_id ;
    

    public int getEvent_capacity() {
        return event_capacity;
    }
    public LocalDate getEvent_date() {
        return event_date;
    }
    public String getEvent_description() {
        return event_description;
    }
    public Time getEvent_duration() {
        return event_duration;
    }
    public Time getEvent_endtime() {
        return event_endtime;
    }
    public int getEvent_id() {
        return id;
    }
    public String getEvent_name() {
        return event_name;
    }
    public int getEvent_org_id() {
        return event_org_id;
    }
    public int getEvent_photos() {
        return event_photos_id;
    }
    public int getEvent_rating() {
        return event_rate_id;
    }
    public int getEvent_spot_id() {
        return event_spot_id;
    }
    public Time getEvent_starttime() {
        return event_starttime;
    }
    public String getEvent_state_id() {
        return event_state_id;
    }
    public int getEvent_type_id() {
        return event_type_id;
    }
    
    
}
