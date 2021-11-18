package pt.iade.wimuuv.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="state")

public class state {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="state_id") private int id;
    @Column(name="state_event") private String state_event;
    public int getState_id() {
        return id;
    }
    public String getState_event() {
        return state_event;
    }
}
