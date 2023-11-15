package com.spring.task.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
@Entity
@Table(name = "tb_useremppass_ev")
public class UserEmpPass {
@Id
	
	
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Type(type = "uuid-char")
	
	@Column(name = "id",updatable = false, nullable = false)

	private UUID id;
	
    @Column(name = "emp_id")
    @Type(type = "uuid-char")
	private UUID empId;
    @Column(name = "employee_name")
	private String employeeName;
    @Column(name = "password")
	private String password;
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public UUID getEmpId() {
		return empId;
	}
	public void setEmpId(UUID empId) {
		this.empId = empId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
    
	
}
