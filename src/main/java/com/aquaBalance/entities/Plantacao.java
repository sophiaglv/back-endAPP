package com.aquaBalance.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Plantacao")
public class Plantacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "cultura")
	private String cultura;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "tamanho")
	private Double tamanho;

	@Column(name = "umidadeIdeal")
	private Double umidadeIdeal;

	@Column(name = "temperaturaIdeal")
	private Double temperaturaIdeal;

	@ManyToOne
	@JoinColumn(name = "idPropriedade", nullable = false)
	private Fazenda propriedade;
	
	public Plantacao(Long id, String cultura, Fazenda propriedade, String descricao, Double tamanho, Double umidadeIdeal,
			Double temperaturaIdeal) {
		super();
		this.id = id;
		this.cultura = cultura;
		this.propriedade = propriedade;
		this.descricao = descricao;
		this.tamanho = tamanho;
		this.umidadeIdeal = umidadeIdeal;
		this.temperaturaIdeal = temperaturaIdeal;
	}

	public Plantacao() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCultura() {
		return cultura;
	}

	public void setCultura(String cultura) {
		this.cultura = cultura;
	}

	public Fazenda getPropriedade() {
		return propriedade;
	}

	public void setPropriedade(Fazenda propriedade) {
		this.propriedade = propriedade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getTamanho() {
		return tamanho;
	}

	public void setTamanho(Double tamanho) {
		this.tamanho = tamanho;
	}

	public Double getUmidadeIdeal() {
		return umidadeIdeal;
	}

	public void setUmidadeIdeal(Double umidadeIdeal) {
		this.umidadeIdeal = umidadeIdeal;
	}

	public Double getTemperaturaIdeal() {
		return temperaturaIdeal;
	}

	public void setTemperaturaIdeal(Double temperaturaIdeal) {
		this.temperaturaIdeal = temperaturaIdeal;
	}
	
	

}