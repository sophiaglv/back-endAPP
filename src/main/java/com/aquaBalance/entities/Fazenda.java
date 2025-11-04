package com.aquaBalance.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Fazenda")
public class Fazenda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;
	
	@Column(name = "Nome da propriedade")
	private String nomePropriedade;
	
	@Column(name = "Estado")
	private String estado;
	
	@Column(name = "Cidade")
	private String cidade;
	
	@Column(name = "Bairro")
	private String bairro;
	
	@Column(name = "Rua")
	private String rua;
	
	@Column(name = "Número")
	private int numero;

	public Fazenda() {
		super();
	}

	public Fazenda(Long id, String nomePropriedade, String estado, String cidade, String bairro,
			String rua, int numero) {
		super();
		this.id = id;
		this.nomePropriedade = nomePropriedade;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomePropriedade() {
		return nomePropriedade;
	}

	public void setNomepropriedade(String nomePropriedade) {
		this.nomePropriedade = nomePropriedade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	@ManyToMany(mappedBy = "fazenda")
	 private Set<Plantacao> plantacao = new HashSet<>();
	
}