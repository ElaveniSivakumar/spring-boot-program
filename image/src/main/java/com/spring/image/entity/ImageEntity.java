package com.spring.image.entity;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_image_keas")
public class ImageEntity {

    
	@Id
	
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Type(type = "uuid-char")
	
	@Column(name = "id",updatable = false, nullable = false)
	private UUID id;
    
    @Column(name = "name")
	private String name;
    
    @Column(name = "image")
    @Lob
	private byte[] image;
    
    @Column(name = "date")
	private LocalDate date;
    
    @Column(name = "status")
	private String status;

	
    
    
}
