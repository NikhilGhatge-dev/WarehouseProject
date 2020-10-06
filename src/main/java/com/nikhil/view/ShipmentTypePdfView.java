package com.nikhil.view;


import java.awt.Color;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.nikhil.model.ShipmentType;


public class ShipmentTypePdfView extends AbstractPdfView{
	
	@Override
	protected void buildPdfDocument(
			Map<String, Object> model, 
			Document document, 
			PdfWriter writer,
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws Exception 
	{
		//file name 
		response.addHeader("Content-Disposition", "attachment;filename=SHIPMENTTYPE.pdf");
		
		//read the data from controller using model
		@SuppressWarnings("unchecked")
		List<ShipmentType> list=(List<ShipmentType>) model.get("list");
		
		Font titleFont =new Font(Font.HELVETICA,30,Font.BOLD,Color.CYAN);
		Paragraph title =new Paragraph("SHIPMENT TYPES",titleFont);
		Paragraph date =new Paragraph(new Date().toString());
		title.setAlignment(Element.ALIGN_CENTER);
		
		PdfPTable table=new PdfPTable(6);
		table.setSpacingBefore(40.0f);
		table.setSpacingAfter(35.0f);
		table.setTotalWidth(new float[] {1.0f,1.0f,1.0f,1.0f,1.0f,2.5f});
		
		table.addCell("ID");
		table.addCell("MODE");
		table.addCell("CODE");
		table.addCell("GRADE");
		table.addCell("ENABLE");
		table.addCell("DESCRIPTION");
		
		for(ShipmentType st:list) {
			table.addCell(String.valueOf(st.getId()));
			table.addCell(st.getShipmentMode());
			table.addCell(st.getShipmentCode());
			table.addCell(st.getShipmentGrade());
			table.addCell(st.getEnableShipment());
			table.addCell(st.getDescirption());
		}
		document.add(title);
		document.add(date);
		document.add(table);
	}
}
