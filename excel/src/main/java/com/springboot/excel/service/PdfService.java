package com.springboot.excel.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.springboot.excel.entity.ExcelEntity;
import com.springboot.excel.repository.ExcelRep;

@Service
public class PdfService {

	@Autowired
	private ExcelRep excelRep;
	
	
	public List<ExcelEntity> listAll(){
		return excelRep.findAll();
		
	}
}
