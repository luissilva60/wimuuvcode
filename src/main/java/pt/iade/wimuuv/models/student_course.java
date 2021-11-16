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
    @Column(name="stu_course_id") private int stu_course_id;
    @Column(name="stu_course_name") private String stu_course_name;
    @Column(name="stu_course_year") private String stu_course_year;

    public int getStu_course_id() {
        return stu_course_id;
    }
    public String getStu_course_name() {
        return stu_course_name;
    }
    public String getStu_course_year() {
        return stu_course_year;
    }
}
