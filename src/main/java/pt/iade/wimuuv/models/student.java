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
    @Column(name="stu_course") private String stu_course;
    @Column(name="stu_bdate") private LocalDate stu_bdate;
    @Column(name="stu_gender") private char stu_gender;
    @Column(name="stu__course_class") private String stu_course_class;
    public student() {}
    public LocalDate getBdate() {
        return stu_bdate;
    }

    public int getCurrentAge() {
        LocalDate now = LocalDate.now();
        return Period.between(stu_bdate, now).getYears();
        }
        
    public String getCourse() {
        return stu_course;
    }
    public String getCourse_class() {
        return stu_course_class;
    }
    public char getGender() {
        return stu_gender;
    }
    public int getId() {
        return stu_id;
    }
    public String getName() {
        return stu_name;
    }
    
    
}   
