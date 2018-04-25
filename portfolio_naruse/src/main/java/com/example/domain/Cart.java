package com.example.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cart")
public class Cart implements Serializable {
	
	private static final long serialVersionUID = -5790232272866392886L;

	@Column(name = "accountid")
    private Integer accountid;
	
	@Column(name = "productsid")
    private Integer productsid;
	
	@Id
    @GeneratedValue
    @Column(name = "cartid")
    private Integer cartid;
	
    @Column(name = "name")
    private String name;
    
    @Column(name = "price")
    private Integer price;
    
    @Column(name = "maker")
    private String maker;
    
    @Column(name = "category")
    private String category;
    
    @Column(name = "count")
    private Integer count;
    

    
    public Cart(int accountid, int productsid, String name, int price, String maker, String category, int count) {
		super();
		this.accountid = accountid;
		this.productsid = productsid;
		this.name = name;
		this.price = price;
		this.maker = maker;
		this.category = category;
		this.count = count;
    }
}
