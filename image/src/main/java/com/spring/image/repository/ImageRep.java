package com.spring.image.repository;

import java.util.UUID;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.image.entity.ImageEntity;
@Repository
public interface ImageRep extends JpaRepository<ImageEntity,UUID> {

}
