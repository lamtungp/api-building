package models;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Table(name = "company")
@Data

public class Company implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    
    @Basic(optional = false)
    @Column(name = "tax_code")
    private String tax_code;
    
    @Basic(optional = false)
    @Column(name = "capital")
    private long capital;
    
    @Basic(optional = false)
    @Column(name = "field_operation")
    private String field_operation;
    
    @Basic(optional = false)
    @Column(name = "phone_number")
    private String phone_number;
}
