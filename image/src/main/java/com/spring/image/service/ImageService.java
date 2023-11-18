package com.spring.image.service;



import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.image.entity.ImageEntity;
import com.spring.image.repository.ImageRep;



@Service
public class ImageService {
	
	@Autowired
	public ImageRep imageRep;

	public void saveImageEntity(ImageEntity imageEntity) {
		imageRep.save(imageEntity);	
		
	}

	public ImageEntity getImageById(UUID id) {
		
		return imageRep.findById(id).orElse(null);
	}

	

	
	
}

