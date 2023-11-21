package com.springboot.excel.controller;


import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;
import com.springboot.excel.entity.ExcelEntity;
import com.springboot.excel.entity.PdfExporter;
import com.springboot.excel.service.PdfService;
@RestController
@RequestMapping("/user")
public class PdfController {
	
	 
	    @Autowired
	    private PdfService pdfService;
	         
	    @GetMapping("/export/pdf")
	    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
	        response.setContentType("application/pdf");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
	        response.setHeader(headerKey, headerValue);
	         
	        List<ExcelEntity> listUsers = pdfService.listAll();
	         
	       PdfExporter exporter = new PdfExporter(listUsers);
	        exporter.export(response);
	         
	    }
	}

