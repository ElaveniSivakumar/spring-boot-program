package com.springboot.excel.entity;

import java.awt.Color;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletResponse;


import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PdfExporter {
	private List<ExcelEntity> listUsers;
    
    public PdfExporter(List<ExcelEntity> listUsers) {
        this.listUsers = listUsers;
    }
 
    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(6);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("S.No", font));
         
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Name", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Address", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Dob", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("E-mail", font));
        table.addCell(cell);   
        
        cell.setPhrase(new Phrase("Phone", font));
        table.addCell(cell); 
        
        cell.setPhrase(new Phrase("Status", font));
        table.addCell(cell);       
    }
     
    private void writeTableData(PdfPTable table) {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    	int serialNumber = 1;
        for (ExcelEntity user : listUsers) {
        	table.addCell(String.valueOf(serialNumber));
            //table.addCell(String.valueOf(user.getId()));
            table.addCell(user.getName());
            table.addCell(user.getAddress());
            table.addCell(dateFormat.format(user.getDob()));
            table.addCell(user.getEmail());
            table.addCell(user.getPhone());
            table.addCell(user.getStatus());
            serialNumber++;
        }
    }
     
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
         
        Paragraph p = new Paragraph("List of Users", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(7);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 2.5f, 2.5f, 1.5f,1.5f});
        table.setSpacingBefore(10);
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
         
    }
}
