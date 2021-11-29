package models;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Table(name = "floor")
@Data

public class Floor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    
    @Basic(optional = false)
    @Column(name = "floor_area")
    private int floor_area;
    
    @Basic(optional = false)
    @Column(name = "unit_price")
    private int unit_price;
    
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    
    @Basic(optional = false)
    @Column(name = "building_id")
    private String building_id;
}
