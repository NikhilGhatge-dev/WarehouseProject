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

import com.nikhil.model.Uom;
import com.nikhil.service.IUomService;
import com.nikhil.view.UomExcelView;
import com.nikhil.view.UomPdfView;

@Controller
@RequestMapping("/uom")
public class UomController {

	@Autowired
	private IUomService service;

	@GetMapping("/register")
	public String showRegister(Model model) {
		//FROM backing Object
		model.addAttribute("uom",new Uom());
		return "UomRegister";
	}

	/***
	 * 2.This is method will read form data as ModelAttribute performs save()
	 * opertion using service that returns ID generated Construct one message and
	 * send UI using Model memory On Entering URL : /save with TYPE :POST
	 */

	@PostMapping("/save")
	public String saveRegister(@ModelAttribute Uom uom, 
		Model model) 
	{
		Integer id = service.saveUom(uom);
		String message = "Uom saved with Id :" + id + "  saved";
		model.addAttribute("message", message);
		
		//FROM backing Object
		model.addAttribute("uom",new Uom());
		return "UomRegister";
	}

	/**
	 * 3. This method gets data from Db using service and send to UI using Model..It
	 * is called when PATH: /all with type GET is reqiuired..
	 * 
	 */
	@GetMapping("/all")
	public String showData(Model model) {
		List<Uom> list = service.getAllUom();
		// sending to UI
		model.addAttribute("list", list);
		return "UomData";
	}
	
	/***
	 * 4. This is method go to database and 
	 * delete to records and display remaining
	 * @param model records and also generate message
	 * @return
	 */
	
	@GetMapping("/delete")
	public String deleteUom(
			@RequestParam Integer id,Model model) 
	{
	 service.deleteUom(id);
	 model.addAttribute("message","uom '"+id+"'deleted");
	 model.addAttribute("list",service.getAllUom());
	  return "UomData";	
	}
	
	/**
	 * 5 . show Edit page on click edit hyperlink
	 *  re:/student/edit?10,Type :Get
	 *  Read Object from DB using PK(Id) sent it to 
	 *  editfrom
	 */
	
	@GetMapping("/edit")
	public String editUom(
			@RequestParam Integer id,
			Model model) 
	{
	 Uom uom=service.getOneUom(id);
	 model.addAttribute("uom",uom);
	 return "UomEdit";
	}
	
	
	// 6. update
	@PostMapping("/update")
	public String updateUom(
			@ModelAttribute Uom uom,
			Model model) 
	{
		service.updateUom(uom);
		 model.addAttribute("message","uom '"+uom.getId()+"'Updated");
		 model.addAttribute("list",service.getAllUom());
		  return "UomData";	
	}
	
	//7. excel
	@GetMapping("/excel")
	public ModelAndView exportToExcel() {
		ModelAndView m= new ModelAndView();
		m.setView(new UomExcelView());
		
		//fetch data from db
		List<Uom> list= service.getAllUom();
		
		//send data to view class
		m.addObject("list",list);
		return m;
	}
	
	//8. PDF
	@GetMapping("/pdf")
	public ModelAndView exportToPdf() {
		ModelAndView m=new ModelAndView();
		m.setView(new UomPdfView());
		
		//fetch data from DB
		List<Uom> list=service.getAllUom();
		//send data to view class
		m.addObject("list",list);
		return m;
	}
}
