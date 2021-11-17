package pt.iade.wimuuv.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="event_spot_photo")
public class event_spot_photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="event_spotph_id") private int event_spotph_id;
    @Column(name="event_ph_id") private int event_ph_id;
    @Column(name="event_sp_id") private int event_sp_id;

    public int getEvent_ph_id() {
        return event_ph_id;
    }
    public int getEvent_sp_id() {
        return event_sp_id;
    }
    public int getEvent_spotph_id() {
        return event_spotph_id;
    }

}
