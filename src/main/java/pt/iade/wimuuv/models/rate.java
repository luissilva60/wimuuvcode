package pt.iade.wimuuv.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rate")

public class rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rate_event") private int event;
    @Column(name="rate_id") private int id;
    @Column(name="ev_rated_id") private int ratedId;
    
    public int getEvent() {
        return event;
    }
    public int getId() {
        return id;
    }
    public int getRatedId() {
        return ratedId;
    }
    

}
