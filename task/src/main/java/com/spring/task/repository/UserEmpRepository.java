package com.spring.task.repository;

import java.util.UUID;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.task.entity.UserEmpTask;

@Repository
public interface UserEmpRepository extends JpaRepository<UserEmpTask,UUID>{

}
