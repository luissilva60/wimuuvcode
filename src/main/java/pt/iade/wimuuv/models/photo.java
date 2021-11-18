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
    @Column(name="photo_path") private String path;
    @Column(name="photo_name") private String name;
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPath() {
        return path;
    }
    
}
