package com.springboot.excel.controller;


import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.springboot.excel.entity.ExcelEntity;
import com.springboot.excel.service.ExcelToDbService;
import com.springboot.excel.service.ExceltoDb;
import com.springboot.excel.service.ResponseMessage;


@RestController
@RequestMapping("/api/excel")
public class ExcelToDbController {
	
	@Autowired
	private ExcelToDbService excelToDbService;
	
	/*@PostMapping("/upload")
	  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
	    String message = "";

	    if (ExceltoDb.hasExcelFormat(file)) {
	      try {
	    	  excelToDbService.save(file);

	        message = "Uploaded the file successfully: " + file.getOriginalFilename();
	        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	      } catch (Exception e) {
	        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	      }
	    }

	    message = "Please upload an excel file!";
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
	  }*/
	
	/*@PostMapping("/upload")
	 public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
	        ExcelEntity excelEntity = new ExcelEntity();
			excelToDbService.save(file);
			return ResponseEntity.ok("Image uploaded successfully");
	    }
	 

	  @GetMapping("/detailsheet")
	  public ResponseEntity<List<ExcelEntity>> getAllTutorials() {
	    try {
	      List<ExcelEntity> tutorials = excelToDbService.getAllTutorials();

	      if (tutorials.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(tutorials, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }*/
	
	@PostMapping("/excel-dow")
    public ResponseEntity<String> handleExcelFileUpload(@RequestParam("file") MultipartFile file) {
        try {
        	
            InputStream excelFile = file.getInputStream();
            List<ExcelEntity> entities = ExceltoDb.parseExcel(excelFile);
            excelToDbService.saveData(entities);
            return ResponseEntity.ok("File uploaded and data saved to the database.");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing the file.");
        }
    }
	}


