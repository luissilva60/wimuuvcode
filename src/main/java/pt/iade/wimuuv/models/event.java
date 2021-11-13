package pt.iade.wimuuv.models;


import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import net.bytebuddy.asm.Advice.Local;

@Entity
@Table(name="event")
public class event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="event_id") private int event_id;
    @Column(name="event_name") private String event_name;
    @Column(name="event_description") private String event_description;
    @Column(name="event_type") private String event_type;
    @Column(name="event_date") private LocalDate event_date;
    @Column(name="event_starttime") private LocalDate event_starttime;
    @Column(name="event_endtime") private LocalDate event_endtime;
    @Column(name="event_duration") private double event_duration;
    @Column(name="event_org") private int event_org;
    @Column(name="event_spot ") private int event_spot ;
    @Column(name="event_capacity") private int event_capacity;
    @Column(name="event_photos") private int event_photos;
    @Column(name="event_state ") private int event_state ;
    @Column(name="event_rating ") private int event_rating ;
    @Column(name="event_qrcodecheck ") private int event_qrcodecheck ;

    public int getEvent_capacity() {
        return event_capacity;
    }
    public LocalDate getEvent_date() {
        return event_date;
    }
    public String getEvent_description() {
        return event_description;
    }
    public double getEvent_duration() {
        return event_duration;
    }
    public LocalDate getEvent_endtime() {
        return event_endtime;
    }
    public int getEvent_id() {
        return event_id;
    }
    public String getEvent_name() {
        return event_name;
    }
    public int getEvent_org() {
        return event_org;
    }
    public int getEvent_photos() {
        return event_photos;
    }
    public int getEvent_qrcodecheck() {
        return event_qrcodecheck;
    }
    public int getEvent_rating() {
        return event_rating;
    }
    public int getEvent_spot() {
        return event_spot;
    }
    public LocalDate getEvent_starttime() {
        return event_starttime;
    }
    public int getEvent_state() {
        return event_state;
    }
    public String getEvent_type() {
        return event_type;
    }
    
    
}
