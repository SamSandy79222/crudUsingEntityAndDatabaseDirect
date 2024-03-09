package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table(name="product")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String name;
private String type;
private long eancode;
	
}
