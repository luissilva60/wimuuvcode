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
    @Column(name="ev_photo_id") private int ev_photo_id;
    @Column(name="stu_photo_id") private int stu_photo_id;
    @Column(name="stu_in_photo_id") private String stu_in_photo_id;
    
    public int getEv_photo_id() {
        return ev_photo_id;
    }
    public int getStu_photo_id() {
        return stu_photo_id;
    }
    public String getStu_in_photo_id() {
        return stu_in_photo_id;
    }
    
}
