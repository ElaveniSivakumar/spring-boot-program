package com.spring.task.repository;

import java.util.UUID;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.task.entity.UserEmpTask;
import com.spring.task.entity.UserTask;
import com.spring.task.entity.ValitationTask;

//first table rep
@Repository
public interface UserRepository extends JpaRepository<UserTask, UUID>{

}

