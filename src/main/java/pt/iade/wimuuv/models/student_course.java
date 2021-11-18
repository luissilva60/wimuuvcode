package pt.iade.wimuuv.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_course")
public class student_course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="stu_course_id") private int id;
    @Column(name="stu_course_name") private String Name;
    

    public int getId() {
        return id;
    }
    public String getName() {
        return Name;
    }
    
}
