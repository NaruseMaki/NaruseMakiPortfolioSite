package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Products implements Serializable {
	
	private static final long serialVersionUID = -870708489937857961L;
	
	@Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "price")
    private Integer price;
    
    @Column(name = "maker")
    private String maker;
    
    @Column(name = "category")
    private String category;
}
