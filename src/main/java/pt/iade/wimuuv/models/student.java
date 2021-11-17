package pt.iade.wimuuv.models;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="stu_name") private String stu_name;
    @Column(name="stu_id") private int stu_id;
    @Column(name="stu_email") private String stu_email;
    @Column(name="stu_password") private String stu_password;
    @Column(name="stu_bdate") private LocalDate stu_bdate;
    @Column(name="stu_gender") private char stu_gender;
    @Column(name="stu_crse_id") private int stu_crse_id;
    public student() {}
    public LocalDate getBdate() {
        return stu_bdate;
    }

    public int getCurrentAge() {
        LocalDate now = LocalDate.now();
        return Period.between(stu_bdate, now).getYears();
    }
    public char getGender() {
        return stu_gender;
    }
    public int getId() {
        return stu_id;
    }
    public String getStu_email() {
        return stu_email;
    }
    public String getName() {
        return stu_name;
    }
    public int getStu_crse_id() {
        return stu_crse_id;
    }

    
    
}   
