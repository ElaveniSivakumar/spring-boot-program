package com.spring.task.entity;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tb_user_sb_elaveni")
public class UserTask {
	@Id
	
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Type(type = "uuid-char")
	
	@Column(name = "id",updatable = false, nullable = false)
	private UUID id;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "phone")
	private String phoneNo;
	
	@Column(name = "email_id")
	private String emailId;
	
	
	
	@Column(name = "joining_date")
	private Date joiningDate;
	
	@JsonManagedReference
	@OneToMany (cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id",referencedColumnName = "id",nullable = false)
	private List<UserInfoTask> userInfoTask;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	
	
}



















/*
 CREATE TABLE `tb_user_sb_elaveni` (
	 INT(11) NOT NULL,
	 VARCHAR(50) NOT NULL COLLATE 'latin1_swedish_ci',
	`` VARCHAR(20) NOT NULL COLLATE 'latin1_swedish_ci',
	`` VARCHAR(20) NOT NULL COLLATE 'latin1_swedish_ci',
	`phone` VARCHAR(10) NOT NULL COLLATE 'latin1_swedish_ci',
	`email_id` VARCHAR(50) NOT NULL COLLATE 'latin1_swedish_ci',
	`joining_date` DATETIME NULL DEFAULT NULL
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;

 */