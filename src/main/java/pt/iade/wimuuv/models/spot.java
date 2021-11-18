package pt.iade.wimuuv.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="spot")

public class spot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="spot_id") private int id;
    @Column(name="spot_name") private String spot_name;
    @Column(name="spot_address") private String spot_address;
    @Column(name="spot_description") private String spot_description;
    @Column(name="spot_photo") private int spot_photo;
    public String getSpot_address() {
        return spot_address;
    }
    public String getSpot_description() {
        return spot_description;
    }
    public int getSpot_id() {
        return id;
    }
    public String getSpot_name() {
        return spot_name;
    }
    public int getSpot_photo() {
        return spot_photo;
    }
    
    
}
