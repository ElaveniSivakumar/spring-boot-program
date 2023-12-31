package com.springboot.excel.service;

import java.io.ByteArrayOutputStream;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.springframework.core.io.ByteArrayResource;

import com.springboot.excel.entity.ExcelEntity;
	
	public class ExcelHelper {
		private static final String DATE_FORMAT = "yyyy-MM-dd";
        
		// TO ACCEPT THE DATE IN EXCEL SHEET
	    private static String formatDate(Date date) {
	        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
	        return sdf.format(date);
	    }
	    
		public static ByteArrayResource generateExcel(List<ExcelEntity> details) {
			try(Workbook workbook = new XSSFWorkbook()){
/* FRONT */	    XSSFSheet sheet = (XSSFSheet) workbook.createSheet("EXCEL-SHEET DETAILS");
				 
				//ALPHABET ORDER 
				if (details != null) {
		                Collections.sort(details, Comparator.comparing(ExcelEntity::getName));
		            }
				
				// Create CellStyle for sheet front
		        CellStyle cellStyle = workbook.createCellStyle();
		        XSSFFont font = (XSSFFont) workbook.createFont();
		        font.setBold(true);
		        font.setFontHeight(25);
		        font.setFontName("Arial");
		        cellStyle.setFont(font);
		        cellStyle.setAlignment(HorizontalAlignment.LEFT);
		        
		        
		     // Write styled content to sheet front
		        Row headerRow = sheet.createRow(0);
		        Cell cell = headerRow.createCell(0);
		        cell.setCellValue("Styled Sheet Front");
		        cell.setCellStyle(cellStyle);
		        headerRow.setRowStyle(cellStyle);
		        
				headerRow.createCell(0).setCellValue("S.No");
				headerRow.createCell(1).setCellValue("name");
				headerRow.createCell(2).setCellValue("address");
				headerRow.createCell(3).setCellValue("dob");
				headerRow.createCell(4).setCellValue("email");
				headerRow.createCell(5).setCellValue("phone");
				headerRow.createCell(6).setCellValue("status");

				if (details != null) {
					for (int i = 0; i < details.size(); i++) {
						Row row = sheet.createRow(i + 1);
						row.createCell(0).setCellValue(i + 1);
						ExcelEntity detailsObj = details.get(i);

						row.createCell(1).setCellValue(detailsObj.getName());
						row.createCell(2).setCellValue(detailsObj.getAddress());
						row.createCell(3).setCellValue(formatDate(detailsObj.getDob()));
						row.createCell(4).setCellValue(detailsObj.getEmail());
						row.createCell(5).setCellValue(detailsObj.getPhone());
						row.createCell(6).setCellValue(detailsObj.getStatus());

					}
				}

				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				workbook.write(outputStream);

				return new ByteArrayResource(outputStream.toByteArray());
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
	}
		




