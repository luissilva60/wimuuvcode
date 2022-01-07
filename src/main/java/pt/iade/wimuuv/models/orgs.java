package pt.iade.wimuuv.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="org")
public class orgs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="org_id") private int id;
    @Column(name="org_name") private String name;
    @Column(name="org_initials") private String initials;
    @Column(name="org_email") private String email;
    @Column(name="org_password") private String password;
    public orgs(){}
    public int getId() {
        return id;
    }
    public String getInitials() {
        return initials;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    
    
}
