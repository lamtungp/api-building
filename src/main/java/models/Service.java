package models;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Table(name = "service")
@Data

public class Service implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    
    @Basic(optional = true)
    @Column(name = "type")
    private String type;
    
    @Basic(optional = false)
    @Column(name = "unit_price")
    private int unit_price;
    
    @Basic(optional = false)
    @Column(name = "building_id")
    private String building_id;
}
