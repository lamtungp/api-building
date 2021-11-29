package models;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Table(name = "used_service")
@Data

public class UsedService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
	
	@Basic(optional = true)
    @Column(name = "month")
    private String month;
    
    @Basic(optional = true)
    @Column(name = "year")
    private String year;
    
    @Column(nullable=false)
    private String service_id;
    
    @Column(nullable=false)
    private String company_id;
    
    @OneToOne(targetEntity=Service.class)
    @JoinColumn(name="service_id", insertable=false, updatable=false)
    private Service service;
    
    @OneToOne(targetEntity=Company.class)
    @JoinColumn(name="company_id", insertable=false, updatable=false)
    private Company company;
}
