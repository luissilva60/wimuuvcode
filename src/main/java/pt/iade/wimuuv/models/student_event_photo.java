package pt.iade.wimuuv.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_event_photo")
public class student_event_photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ev_photo_id") private int id;
    @Column(name="stu_photo_id") private int photoId;
    @Column(name="stu_in_photo_id") private String stuInPhotoId;
    
    public int getEv_photo_id() {
        return id;
    }
    public int getPhotoId() {
        return photoId;
    }
    public String getStuInPhotoId() {
        return stuInPhotoId;
    }
    
}
