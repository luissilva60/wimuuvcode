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
    @Column(name="org_id") private int org_id;
    @Column(name="org_name") private String org_name;
    @Column(name="org_initials") private String org_initials;
    public orgs(){}
    public int getOrg_id() {
        return org_id;
    }
    public String getOrg_initials() {
        return org_initials;
    }
    public String getOrg_name() {
        return org_name;
    }
    
    
}
