package com.spring.task.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.task.entity.ValitationTask;
@Repository
public interface ValidationRep extends JpaRepository<ValitationTask, UUID>{

ValitationTask findByEmailAndPhone(String email, String phone);
	
}


