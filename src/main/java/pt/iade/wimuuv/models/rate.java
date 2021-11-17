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
    @Column(name="rate_event") private int rate_event;
    @Column(name="rate_id") private int rate_id;
    @Column(name="ev_rated_id") private int ev_rated_id;
    
    public int getRate_event() {
        return rate_event;
    }
    public int getRate_id() {
        return rate_id;
    }
    public int getEv_rated_id() {
        return ev_rated_id;
    }
    

}
