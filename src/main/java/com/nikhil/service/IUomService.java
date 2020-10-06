package com.nikhil.service;

import java.util.List;

import com.nikhil.model.Uom;

public interface IUomService {
	/** 1.
	 * This method read form data as model class
	 * @param u  indicate modelAttribute 
	 * @return Integer PK generated after save
	 */
	public Integer saveUom(Uom u);
	/**
	 * 2.
	 * this methods used to feacth Data from DataBase
	 * using findAll() methods and 
	 * List<Student> back to UI
	 */
	public List<Uom> getAllUom();
	
	/**
	 * 3 delete records
	 */
	public void deleteUom(Integer id);
	
	/**
	 * 4.
	 * this methods read in as input
	 * and returns Uom object else UOMelseNotFoundException
	 * @return 
	 */
	public Uom getOneUom(Integer id);
	/***
	 * This method is used to update student based on Id(PK)
	 */
	public void updateUom(Uom u);
}
