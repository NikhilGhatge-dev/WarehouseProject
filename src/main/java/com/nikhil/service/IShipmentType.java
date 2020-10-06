package com.nikhil.service;

import java.util.List;

import com.nikhil.model.ShipmentType;

public interface IShipmentType {

	public Integer saveShipmentType(ShipmentType st);

	public void updateShipmentType(ShipmentType st);

	public void deleteShipmentType(Integer id);

	public ShipmentType getOneShipmentType(Integer id);

	public List<ShipmentType> getAllShipmentType();
}
