package com.dailycodelearner.entity;

//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {

//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String place;
	private String type;
	private int waranty;
}
