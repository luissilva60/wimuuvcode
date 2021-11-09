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
    @Column(name="type_id") private int type_id;
    @Column(name="type_name") private String type_name;
    @Column(name="type_event") private String type_event;
    public String getType_event() {
        return type_event;
    }
    public int getType_id() {
        return type_id;
    }
    public String getType_name() {
        return type_name;
    }
    
    
}
