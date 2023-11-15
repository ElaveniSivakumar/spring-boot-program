package com.spring.task.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.task.entity.UserInfoTask;
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfoTask,UUID>{

}
