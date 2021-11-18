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
    @Column(name="event_spotph_id") private int id;
    @Column(name="event_ph_id") private int phId;
    @Column(name="event_sp_id") private int spId;

    public int getPhId() {
        return phId;
    }
    public int getSpId() {
        return spId;
    }
    public int getId() {
        return id;
    }

}
