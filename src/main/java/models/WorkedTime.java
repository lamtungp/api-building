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
@Table(name = "worked_time")
@Data

public class WorkedTime implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
	
	@Basic(optional = true)
    @Column(name = "worked_days")
    private int worked_days;
    
    @Basic(optional = true)
    @Column(name = "worked_date")
    private String worked_date;
    
    @Column(nullable=false)
    private String staff_id;
    
    @Column(nullable=false)
    private String salary_id;
    
    @OneToOne(targetEntity=Staff.class)
    @JoinColumn(name="staff_id", insertable=false, updatable=false)
    private Staff staff;
    
    @OneToOne(targetEntity=Salary.class)
    @JoinColumn(name="salary_id", insertable=false, updatable=false)
    private Salary salary;
}
