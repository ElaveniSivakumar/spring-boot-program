package com.spring.task.entity;

import java.util.UUID;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "tb_userinfo_ev")
public class UserInfoTask {
	
@Id
	
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Type(type = "uuid-char")
	
	@Column(name = "id",updatable = false, nullable = false)
	private UUID id;
    
//    @Column(name = "user_id")
//    private UUID userId;
    
    @Column(name = "age")
    private Integer age;
    
    @Column(name = "gender")
    private String gender;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "state")
    private String state;
    
    @Column(name = "postal_code")
    private String postalCode;
    
    @Column(name = "country")
    private String country;

    @JsonBackReference
	@ManyToOne
    @JoinColumn(name = "user_id", nullable = false,insertable = false,updatable = false)
    private UserTask userTask;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}



	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public UserTask getUserTask() {
		return userTask;
	}

	public void setUserTask(UserTask userTask) {
		this.userTask = userTask;
	}
    
    
    
    

}














/*
 CREATE TABLE `tb_userinfo_ev` (
	`id` CHAR(36) NOT NULL DEFAULT '' COLLATE 'latin1_swedish_ci',
	`user_id` CHAR(36) NOT NULL DEFAULT '' COLLATE 'latin1_swedish_ci',
	`age` INT(11) NULL DEFAULT NULL,
	`gender` VARCHAR(10) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
	`address` VARCHAR(50) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
	`state` VARCHAR(25) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
	`postal_code` VARCHAR(10) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
	`country` VARCHAR(25) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
	PRIMARY KEY (`id`) USING BTREE,
	INDEX `FK_tb_userinfo_ev_tb_user_sb_elaveni` (`user_id`) USING BTREE,
	CONSTRAINT `FK_tb_userinfo_ev_tb_user_sb_elaveni` FOREIGN KEY (`user_id`) REFERENCES `tb_user_sb_elaveni` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;

 */
