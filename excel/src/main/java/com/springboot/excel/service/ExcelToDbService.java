package com.springboot.excel.service;

import java.io.IOException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.excel.entity.ExcelEntity;
import com.springboot.excel.repository.ExcelRep;

@Service
public class ExcelToDbService {

	
	  @Autowired
	  private ExcelRep excelRep;

	 /* public void save(MultipartFile file) {
	    try {
	      List<ExcelEntity> tutorials = ExceltoDb.excelToTutorials(file.getInputStream());
	      excelRep.saveAll(tutorials);
	    } catch (IOException e) {
	      throw new RuntimeException("fail to store excel data: " + e.getMessage());
	    }
	  }

	  public List<ExcelEntity> getAllTutorials() {
	    return excelRep.findAll();
	  }*/
	  
	  public void saveData(List<ExcelEntity> entities) {
	        excelRep.saveAll(entities);
	    }
	}

