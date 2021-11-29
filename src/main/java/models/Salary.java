package models;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Table(name = "salary")
@Data

public class Salary implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    
    @Basic(optional = false)
    @Column(name = "position")
    private String position;
    
    @Basic(optional = false)
    @Column(name = "salary_grade")
    private int salary_grade;
    
    @Basic(optional = false)
    @Column(name = "salary")
    private long salary;
}
