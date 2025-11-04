package com.aquaBalance.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cultura")
public class Cultura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;
	
	@Column(name = "Tipo de cultura")
	private String tipoCultura;

	public Cultura() {
		super();
	}

	public Cultura(Long id, String tipoCultura) {
		super();
		this.id = id;
		this.tipoCultura = tipoCultura;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoCultura() {
		return tipoCultura;
	}

	public void setTipoCultura(String tipoCultura) {
		this.tipoCultura = tipoCultura;
	}
	
	
}