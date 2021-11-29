package models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Table(name = "staff")
@Data

public class Staff implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    
    @Basic(optional = false)
    @Column(name = "address")
    private String address;
    
    @Basic(optional = false)
    @Column(name = "dob")
    private Date dob;
    
    @Basic(optional = false)
    @Column(name = "phone_number")
    private String phone_number;
    
    @Basic(optional = false)
    @Column(name = "floor_id")
    private String floor_id;
    
    @Basic(optional = false)
    @Column(name = "salary_id")
    private String salary_id;
    
    @Basic(optional = false)
    @Column(name = "building_id")
    private String building_id;
    
    @OneToOne(targetEntity=Floor.class)
    @JoinColumn(name="floor_id", insertable=false, updatable=false)
    private Floor location;
    
    @OneToOne(targetEntity=Salary.class)
    @JoinColumn(name="salary_id", insertable=false, updatable=false)
    private Salary position;
    
    @OneToOne(targetEntity=Building.class)
    @JoinColumn(name="building_id", insertable=false, updatable=false)
    private Building building;
}
