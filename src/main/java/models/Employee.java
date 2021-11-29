package models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Table(name = "employee")
@Data

public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    
    @Basic(optional = false)
    @Column(name = "dob")
    private Date dob;
    
    @Basic(optional = false)
    @Column(name = "card_id")
    private String card_id;
    
    @Basic(optional = false)
    @Column(name = "phone_number")
    private String phone_number;
    
    @Basic(optional = false)
    @Column(name = "company_id")
    private String company_id;
}
