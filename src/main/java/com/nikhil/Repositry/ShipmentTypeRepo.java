package com.nikhil.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nikhil.model.ShipmentType;

public interface ShipmentTypeRepo extends JpaRepository<ShipmentType, Integer> {

}
