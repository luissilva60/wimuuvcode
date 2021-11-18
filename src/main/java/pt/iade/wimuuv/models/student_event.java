package pt.iade.wimuuv.models;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_event")

public class student_event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="stu_ev_id") private int id;
    @Column(name="stu_entry_id") private int stu_entry_id;
    @Column(name="stu_ev_entrytime") private Timestamp stu_ev_entrytime;
    @Column(name="ev_id") private int ev_id;

    public Timestamp getStu_ev_entrytime() {
        return stu_ev_entrytime;
    }
    public int getStu_ev_id() {
        return id;
    }
    public int getStu_entry_id() {
        return stu_entry_id;
    }
    public int getEv_id() {
        return ev_id;
    }
    
}
