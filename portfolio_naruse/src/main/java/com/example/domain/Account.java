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
@Table(name = "account")
public class Account implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@GeneratedValue
    @Column(name = "id")
    private Integer id;
    
	@Id
	@Column(name = "loginid")
    private String loginid;
	
	@Column(name = "name")
    private String name;
	
	@Column(name = "pass")
    private String pass;
	
	@Column(name = "address")
    private String address;
	
	
	public Account(String loginid, String name, String pass, String address) {
		super();
		this.loginid = loginid;
		this.name = name;
		this.pass = pass;
		this.address = address;
	}
	
}
