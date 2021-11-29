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
@Table(name = "used_area")
@Data

public class UsedArea implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
	
	@Basic(optional = true)
    @Column(name = "used_area")
    private int used_area;
    
    @Column(nullable=false)
    private String floor_id;
    
    @Column(nullable=false)
    private String company_id;
    
    @Basic(optional = true)
    @Column(name = "rental_term")
    private String rental_term;
    
    @OneToOne(targetEntity=Floor.class)
    @JoinColumn(name="floor_id", insertable=false, updatable=false)
    private Floor floor;
    
    @OneToOne(targetEntity=Company.class)
    @JoinColumn(name="company_id", insertable=false, updatable=false)
    private Company company;
}
