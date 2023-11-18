package com.springboot.excel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.excel.entity.ExcelEntity;
import com.springboot.excel.service.ExcelHelper;
import com.springboot.excel.service.ExcelService;


@RestController
@RequestMapping("/user")
public class ExcelController {
	
@Autowired
private ExcelService excelService;


@PostMapping(value = "/create")
public ResponseEntity<ExcelEntity> createDetails(@RequestBody ExcelEntity detailsEntity) {
	excelService.savedetail(detailsEntity);
	return ResponseEntity.ok(detailsEntity);
	
}
@GetMapping(value = "/fetch")
	public  ResponseEntity<Resource> downloadDetails() {
 List<ExcelEntity> excelEntities = excelService.getAll();
    ByteArrayResource resource = ExcelHelper.generateExcel(excelEntities);
    return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=Detailsheet.xlsx")
            .contentType(MediaType.APPLICATION_OCTET_STREAM)
            .contentLength(resource.contentLength())
            .body(resource);
    }

}

