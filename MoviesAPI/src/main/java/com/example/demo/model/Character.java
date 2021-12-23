package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Constructor
@AllArgsConstructor @NoArgsConstructor
public class Character {
	
	//Attributes
	private @Setter @Getter String name;
	private @Setter @Getter Integer bornYear;
	private @Setter @Getter String nationality; 
	private @Setter @Getter String rolPlay;
}
