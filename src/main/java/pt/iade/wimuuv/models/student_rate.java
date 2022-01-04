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
    @Column(name="stu_rate_ev") private int stuRateEv;
    @Column(name="stu_rate_comment") private String comment;
    @Column(name="stu_rid") private int stuRid;
    @Column(name="ev_rid") private int evRid;
    public int getEvRid() {
        return evRid;
    }
    public int getStuRateEv() {
        return stuRateEv;
    }
    public int getId() {
        return id;
    }
    public int getStuRid() {
        return stuRid;
    }  
    public String getComment() {
        return comment;
    }
    
}
