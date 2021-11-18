package pt.iade.wimuuv.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="type")

public class type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="type_id") private int id;
    @Column(name="type_name") private String name;
    @Column(name="type_event") private String event;
    public String getEvent() {
        return event;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    
    
}
