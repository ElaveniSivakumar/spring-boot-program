package com.springboot.excel.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.springboot.excel.entity.ExcelEntity;
import com.springboot.excel.repository.ExcelRep;

@Service
public class ExcelService {
	

		@Autowired
		public ExcelRep excelRep;
		

		public void savedetail(ExcelEntity details) {
			excelRep.save(details);	
		}
		
		public List<ExcelEntity> getAll() {
			return (List<ExcelEntity>) excelRep.findAll();
		}
	}


