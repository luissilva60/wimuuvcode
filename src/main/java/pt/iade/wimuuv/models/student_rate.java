package pt.iade.wimuuv.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="student_rate")
public class student_rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="stu_rate_id") private int id;
    @Column(name="stu_rate_ev") private int stu_rate_ev;
    @Column(name="stu_rid") private int stu_rid;
    @Column(name="ev_rid") private int ev_rid;
    public int getEv_rid() {
        return ev_rid;
    }
    public int getStu_rate_ev() {
        return stu_rate_ev;
    }
    public int getStu_rate_id() {
        return id;
    }
    public int getStu_rid() {
        return stu_rid;
    }  
    
}
