/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.finalproject.view;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.Header;
import com.lowagie.text.Font;

import com.lowagie.text.FontFactory;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;

import edu.neu.finalproject.pojo.AcceptedRequests;
import edu.neu.finalproject.pojo.RequestAdvert;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author soman
 */

public class ConfirmationPdfView extends AbstractPdfView {
    

//    @Override 
//    protected void buildPdfDocument(Map<String, Object> map, Document doc, PdfWriter writer, HttpServletRequest req, HttpServletResponse res) throws Exception {
//        
//        AcceptedRequests user = (AcceptedRequests) map.get("AcceptedRequests");
//        
//        final HeaderFooter header = new HeaderFooter(new Phrase("Immune And Insprire"), false);
//	header.setAlignment(Element.ALIGN_LEFT);
//	header.setBorder(Rectangle.NO_BORDER);
//	doc.setHeader(header);
//       
//        Paragraph h = new Paragraph("Immune And Insprire");
//        Paragraph e1 = new Paragraph("Accepted Request ID : " + user.getARId());
//        Paragraph e2 = new Paragraph("Provider Name : " + user.getProvider().getFirstName() + " " + user.getProvider().getLastName());
//        Paragraph e3 = new Paragraph("Date Accepted : " + user.getDateaccepted());
//        Paragraph e4 = new Paragraph("Requested Vaccine : " + user.getRequestAdvert().getVaccine());
//        Paragraph e5 = new Paragraph("Estimated Price : " + user.getEstimatedcost());
//        Paragraph e6 = new Paragraph("Your Confirmation is valid for 7 Days");
//       
//        doc.add(h);
//        doc.add(e1);
//        doc.add(e2);
//        doc.add(e4);
//        doc.add(e3); 
//        doc.add(e5);
//        doc.add(e6);
//    }   
    
    @Override 
    protected void buildPdfDocument(Map<String, Object> map, Document doc, PdfWriter writer, HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        AcceptedRequests user = (AcceptedRequests) map.get("AcceptedRequests");
        
        doc.add(new Paragraph("This is your confirmation for vaccination from Immune And Insprire. "
                + "Please bring a copy of this document during vaccination. "
                + "Your Confirmation is valid for 7 Days from the Request Accept Date. "
                + "  "));
       
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[] {2.0f, 2.0f, 2.0f, 2.0f, 2.0f});
        table.setSpacingBefore(10);
               
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        PdfPCell cell = new PdfPCell();
        cell.setPadding(5);
        
        cell.setPhrase(new Phrase("Accepted Request ID : ", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Provider Name : ", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Requested Vaccine : ", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Estimated Price : ",  font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Date Accepted :", font));
        table.addCell(cell);
         
        table.addCell(String.valueOf(user.getARId()));
        table.addCell(user.getProvider().getFirstName() + " " + user.getProvider().getLastName());
        table.addCell(user.getRequestAdvert().getVaccine());
        table.addCell(String.valueOf(user.getEstimatedcost()));
        table.addCell(String.valueOf(user.getDateaccepted()));       
         
        doc.add(table);
    } 
}
