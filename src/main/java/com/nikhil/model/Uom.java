package com.nikhil.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Uom_tab")
public class Uom {
	
	@Id
	@GeneratedValue
	@Column(name = "col_id_tab")
	private Integer id;
	@Column(name = "col_type_tab")
	private String type;
	@Column(name = "col_model_tab")
	private String model;
	@Column(name = "col_description_tab")
	private String description;
}
