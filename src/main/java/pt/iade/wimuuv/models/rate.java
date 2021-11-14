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
    @Column(name="rate_spot") private int rate_spot;
    @Column(name="rate_org") private int rate_org;
    @Column(name="rate_id") private int rate_id;
    public rate(){}
    public int getRate_event() {
        return rate_event;
    }
    public int getRate_org() {
        return rate_org;
    }
    public int getRate_spot() {
        return rate_spot;
    }
    public int getRate_id() {
        return rate_id;
    }
    

}
