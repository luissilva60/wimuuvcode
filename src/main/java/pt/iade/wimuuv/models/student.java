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
@Table(name="student")
public class student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="stu_id") private int id;
    @Column(name="stu_name") private String name;
    @Column(name="stu_email") private String email;
    @Column(name="stu_password") private String password;
    @Column(name="stu_bdate") private LocalDate bdate;
    @Column(name="stu_gender") private char gender;
    @Column(name="stu_crse_id") private int crseId;
    @Column(name="stu_photo_id") private int photoId;
    public student() {}
    public LocalDate getBdate() {
        return bdate;
    }

    public int getCurrentAge() {
        LocalDate now = LocalDate.now();
        return Period.between(bdate, now).getYears();
    }
    public char getGender() {
        return gender;
    }
    public int getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public String getName() {
        return name;
    }
    public int getCrseId() {
        return crseId;
    }
    public int getPhotoId() {
        return photoId;
    }

    
    
}   
