package com.nikhil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nikhil.model.ShipmentType;
import com.nikhil.model.Uom;
import com.nikhil.service.IShipmentType;
import com.nikhil.view.ShipmentTypeExcelView;
import com.nikhil.view.ShipmentTypePdfView;

@Controller
@RequestMapping("/shipmentType")
public class ShipmentTypeController {
	
	@Autowired
	private IShipmentType service;
	
	//1. save register page
	@GetMapping("/register")
	public String showReg(Model model) {
		//FROM backing Object
		model.addAttribute("shipmentType",new ShipmentType());
		
		return "ShipmentTypeRegister";
	}
	
	//2 . save
	@PostMapping("/save")
	public String save(
			@ModelAttribute ShipmentType shipmentType,
			Model model) 
	{
		Integer id=service.saveShipmentType(shipmentType);
		String message="ShipmentType '"+id+"' saved";
		model.addAttribute("message",message);
		
		//FROM backing Object
		model.addAttribute("shipmentType",new ShipmentType());
		return "ShipmentTypeRegister";
	}
	
	//3 . Display
	@GetMapping("/all")
	public String showAll(Model model) {
		List<ShipmentType> list=service.getAllShipmentType();
		model.addAttribute("list",list);
		return "ShipmentTypeData";
	}
	
	//4. delete by id
	@GetMapping("/delete")
	public String deleteShipmentType(
			@RequestParam Integer id,Model model) 
	{
		service.deleteShipmentType(id);
		model.addAttribute("message","ShipmentType"+id+"Deleted");
		model.addAttribute("list",service.getAllShipmentType());
		return "ShipmentTypeData";
	}
	
	//5 . show edit
	@GetMapping("/edit")
	public String showEdit(
			@RequestParam Integer id,
			Model model
			) {
		ShipmentType shipment=service.getOneShipmentType(id);
		model.addAttribute("shipmentType",shipment);
		return "ShipmentTypeEdit";
	}
	
	//6.update 
	
	@PostMapping("/update")
	public String Update(
			@ModelAttribute ShipmentType shipmenttype,
			Model model) 
	{
		service.updateShipmentType(shipmenttype);
		model.addAttribute("message","shipmentType"+shipmenttype.getId()+"updated");
		model.addAttribute("list",service.getAllShipmentType());
		return "ShipmentTypeData";
	}
	
	//7 .excel
	@GetMapping("/excel")
	public ModelAndView expertExcel() {
		ModelAndView m=new ModelAndView();
		m.setView(new ShipmentTypeExcelView());
		
		//fetch service class 
		List<ShipmentType> list=service.getAllShipmentType();
		m.addObject("list",list);
		
		if(list==null || list.isEmpty()) {
			m.addObject("message","NO DATA FOR EXCEL EXPORT");
			m.setViewName("ShipmentTypeData");
		}else {
			m.setView(new ShipmentTypeExcelView());
		}
		return m;
	}
	
	//8.pdf
	
	@GetMapping("/pdf")
	public ModelAndView expertPdf() {
		ModelAndView m=new ModelAndView();
		m.setView(new ShipmentTypeExcelView());
		
		//fetch service class 
		List<ShipmentType> list=service.getAllShipmentType();
		m.addObject("list",list);
		
		if(list==null || list.isEmpty()) {
			m.addObject("message","NO DATA FOR PDF EXPORT");
			m.setViewName("ShipmentTypeData");
		}else {
			m.setView(new ShipmentTypePdfView());
		}
		return m;
	}
	
}
	