package com.nikhil.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.nikhil.model.ShipmentType;

public class ShipmentTypeExcelView extends AbstractXlsxView{
	
	@Override
	protected void buildExcelDocument(
					Map<String, Object> model, 
					Workbook workbook, 
					HttpServletRequest request,
					HttpServletResponse response) 
					throws Exception 
	{
		//file name
		response.addHeader("Content-Disposition", "attachment;filename=shipmentType.xlsx");
		
		//read data from model
		@SuppressWarnings("unchecked")
		List<ShipmentType> list=(List<ShipmentType>) model.get("list");
		
		//create new sheet
		Sheet sheet= workbook.createSheet("SHIPMENTTYPE");
		
		setHeader(sheet);
		setBody(sheet,list);
	}
	
	private void setBody(Sheet sheet, List<ShipmentType> list) {
		int rowNum= 1;
		for(ShipmentType st:list) {
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(st.getId());
			row.createCell(1).setCellValue(st.getShipmentMode());
			row.createCell(2).setCellValue(st.getShipmentCode());
			row.createCell(3).setCellValue(st.getEnableShipment());
			row.createCell(4).setCellValue(st.getShipmentGrade());
			row.createCell(5).setCellValue(st.getDescirption());
		}
	}

	private void setHeader(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("Id");
		row.createCell(1).setCellValue("SHIPMENTMODE");
		row.createCell(2).setCellValue("SHIPMENTCODE");
		row.createCell(3).setCellValue("ENABLESHIPMENT");
		row.createCell(4).setCellValue("SHIPMENTGRADE");
		row.createCell(5).setCellValue("DESCIRPTION");
	}


}
