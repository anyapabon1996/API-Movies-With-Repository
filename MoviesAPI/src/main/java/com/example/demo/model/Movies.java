package com.example.demo.model;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Este sera el componente Entidad
@Entity @AllArgsConstructor @NoArgsConstructor
public class Movies implements Serializable{

	//El id se autoincrementa solo, no puede editarse ni ser campo vacio. 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private @Setter @Getter Integer id;
	private @Setter @Getter Integer premiere; 
	private @Setter @Getter String title;
	private @Setter @Getter String image;
	private @Setter @Getter double qualification;
	private @Setter @Getter Classification classify; 
	private @Setter @Getter Gender gender; 
	private @Setter @Getter boolean bloodyOne; 
	
}
