/*package com.springboot.excel.entity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.UUID;

import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;
public class PdfHelper {
	private static final Logger LOG = LoggerFactory.getLogger(PdfHelper.class);
    public byte[] generatePdf(String templatePath, Map<String, Object> contextVariables) 
            throws DocumentException, IOException {
        Context context = new Context();
        context.setVariables(contextVariables);
        String html = getThymeleafTemplateEngine().process(templatePath, context);
        
        Path path = Files.createTempFile(UUID.randomUUID().toString(), ".pdf");
        OutputStream outputStream = Files.newOutputStream(path);
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(html);
        renderer.layout();
        renderer.createPDF(outputStream);
        outputStream.close();
        LOG.debug("Wrote PDF file for template {}: {}", templatePath, path);
        byte[] bytes = Files.readAllBytes(path);
        Files.delete(path);
        return bytes;
    }
}*/
