package com.nikhil.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.nikhil.Repositry.UomRepositry;
import com.nikhil.exception.UomNotFoundExeption;
import com.nikhil.model.Uom;
import com.nikhil.service.IUomService;

@Service
public class UomServiceImpl implements IUomService {
	@Autowired
	private UomRepositry repo;
	
	@Override
	public Integer saveUom(Uom u) {
		//after save(obj) same object is returned with ID effected
		u=repo.save(u);
		return u.getId();
	}

	
	@Override
	public List<Uom> getAllUom() {
		List<Uom> list=repo.findAll();
		list.sort((e1,e2)->e1.getId() - e2.getId());
		return list;
	}

	
	@Override
	public void deleteUom(Integer id) { 
		repo.deleteById(id);
	}


	@Override
	public Uom getOneUom(Integer id) {
		Uom uom;
		uom=repo.findById(id)
				.orElseThrow
				(
				()-> 
				new UomNotFoundExeption("Uom"+id+"not updated")
				);
		return uom;
	}


	@Override
	public void updateUom(Uom u) {
		repo.save(u);
		
	}
	
	

}
