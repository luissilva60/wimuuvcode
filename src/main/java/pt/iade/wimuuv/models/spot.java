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
    @Column(name="spot_name") private String name;
    @Column(name="spot_long") private double longitude;
    @Column(name="spot_lat") private double latitude;
    @Column(name="spot_description") private String description;
    @Column(name="spot_photo_id") private int photoId;
    
    public String getDescription() {
        return description;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getPhotoId() {
        return photoId;
    }
    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    
    
}
