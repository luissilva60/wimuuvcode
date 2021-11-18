package pt.iade.wimuuv.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="photo")
public class photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="photo_id") private int id;
    @Column(name="photo_path") private String photo_path;
    @Column(name="photo_name") private String photo_name;
    public int getPhoto_id() {
        return id;
    }
    public String getPhoto_name() {
        return photo_name;
    }
    public String getPhoto_path() {
        return photo_path;
    }
    
}
