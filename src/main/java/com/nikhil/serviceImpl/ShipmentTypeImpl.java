package com.nikhil.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nikhil.Repositry.ShipmentTypeRepo;
import com.nikhil.exception.ShipmentTypeNotFoundException;
import com.nikhil.model.ShipmentType;
import com.nikhil.service.IShipmentType;


@Service
public class ShipmentTypeImpl implements IShipmentType {
	
	@Autowired
	private ShipmentTypeRepo repo;
	
	@Override
	public Integer saveShipmentType(ShipmentType st) {
		return repo.save(st).getId();
	}

	@Override
	public List<ShipmentType> getAllShipmentType() {
		List<ShipmentType>list=repo.findAll();
		list.sort((e1,e2)->e1.getId() - e2.getId());
		return list;
	}
	
	
	@Override
	public void deleteShipmentType(Integer id) {
		repo.deleteById(id);
	}
	
	
	@Override
	public ShipmentType getOneShipmentType(Integer id) {
		ShipmentType st=repo.findById(id)
				.orElseThrow
						(
						()->
						new ShipmentTypeNotFoundException("ShipmentType '"+id+"' Not exited")
						);
						repo.delete(st);
		return st;
	}
	
	@Override
	public void updateShipmentType(ShipmentType st) {	
		repo.save(st);
	}

	

}
