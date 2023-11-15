
// HIBERNATE TABLE(data base) MAPPING  {entity/class/bean/pojo}

package com.spring.jpa.entity;

import java.time.LocalDateTime;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "tb_user1_sb_ev")
public class User {
	
	@Id
	
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Type(type = "uuid-char")
	
	@Column(name = "id",updatable = false, nullable = false)
	private UUID id;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "create_date")
	private LocalDateTime createDate;
	
	@Column(name = "modified_date")
	private LocalDateTime modifiedDate;

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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	
	/*
	 
	 CREATE TABLE `tb_user1_sb_ev` (
	`` CHAR(36) NOT NULL DEFAULT '' COLLATE 'latin1_swedish_ci',
	`` VARCHAR(250) NOT NULL DEFAULT '' COLLATE 'latin1_swedish_ci',
	`` VARCHAR(250) NOT NULL DEFAULT '' COLLATE 'latin1_swedish_ci',
	`` DATETIME NULL DEFAULT NULL,
	`` DATETIME NULL DEFAULT NULL
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;




	 */
	
	
	

}
