package com.springboot.excel.service;

import java.io.IOException;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.excel.entity.ExcelEntity;

public class ExceltoDb {
	/*public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	  static String[] HEADERs = { "id", "name", "address", "dob" , "email", "phone", "status"};
	  static String SHEET = "Tutorials";

	  /*public static boolean hasExcelFormat(MultipartFile file) {

	    if (!TYPE.equals(file.getContentType())) {
	      return false;
	    }

	    return true;
	  }*/

	  /*public static List<ExcelEntity> excelToTutorials(InputStream is) {
	    try {
	      XSSFWorkbook workbook = new XSSFWorkbook(is);
	      //Workbook workbook = WorkbookFactory.create(is);
	      //Sheet ssheet = workbook.getSheetAt(0);
	      Sheet sheet = workbook.getSheet(SHEET);
	      Iterator<Row> rows = sheet.iterator();

	      List<ExcelEntity> tutorials = new ArrayList<ExcelEntity>();

	      int rowNumber = 0;
	      while (rows.hasNext()) {
	        Row currentRow = rows.next();

	        // skip header
	        if (rowNumber == 0) {
	          rowNumber++;
	          continue;
	        }

	        Iterator<Cell> cellsInRow = currentRow.iterator();

	        ExcelEntity tutorial = new ExcelEntity();

	        int cellIdx = 0;
	        while (cellsInRow.hasNext()) {
	          Cell currentCell = cellsInRow.next();

	          switch (cellIdx) {
	          case 0:
	            //tutorial.setId((char) currentCell.getNumericCellValue());
	            break;

	          case 1:
	            tutorial.setName(currentCell.getStringCellValue());
	            break;

	          case 2:
	            tutorial.setAddress(currentCell.getStringCellValue());
	            break;

	          case 3:
	            tutorial.setDob(currentCell.getDateCellValue());
	            break;
	          case 4:
		            tutorial.setEmail(currentCell.getStringCellValue());
		            break;
	          case 5:
		            tutorial.setPhone(currentCell.getStringCellValue());
		            break;
	          case 6:
		            tutorial.setStatus(currentCell.getStringCellValue());
		            break;

	          default:
	            break;
	          }

	          cellIdx++;
	        }

	        tutorials.add(tutorial);
	      }

	      workbook.close();

	      return tutorials;
	    } catch (IOException e) {
	      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
	    }
	  }*/
	
	public static List<ExcelEntity> parseExcel(InputStream excelFile) throws IOException {
        List<ExcelEntity> entities = new ArrayList<>();

        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet sheet = workbook.getSheetAt(0); // Assuming the data is in the first sheet

        for (Row row : sheet) {
        	ExcelEntity entity = new ExcelEntity();
            entity.setId((char)row.getCell(0).getNumericCellValue());
            entity.setName(row.getCell(1).getStringCellValue());
            entity.setAddress(row.getCell(2).getStringCellValue());
            entity.setDob(row.getCell(3).getDateCellValue());
            entity.setEmail(row.getCell(4).getStringCellValue());
            entity.setPhone(row.getCell(5).getStringCellValue());
            entity.setStatus(row.getCell(6).getStringCellValue());
            // Set other fields as needed

            entities.add(entity);
        }

        workbook.close();
        return entities;
    }
}

