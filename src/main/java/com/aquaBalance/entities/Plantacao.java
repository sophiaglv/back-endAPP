package com.aquaBalance.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "Plantacao")
public class Plantacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
   
    @ManyToOne
    @JoinColumn(name = "idCultura", nullable = false)
    private Cultura cultura;

    @Column(name = "Descricao")
    private String descricao;

    @Column(name = "Tamanho")
    private double tamanho;

    @Column(name = "UmidadeIdeal")
    private Double umidadeIdeal;
    
    @Column(name = "TemperaturaIdeal")
    private Double TemperaturaIdeal;

	public Plantacao(Long id, String descricao, double tamanho, Double umidadeIdeal, Double temperaturaIdeal) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.tamanho = tamanho;
		this.umidadeIdeal = umidadeIdeal;
		TemperaturaIdeal = temperaturaIdeal;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getTamanho() {
		return tamanho;
	}

	public void setTamanho(double tamanho) {
		this.tamanho = tamanho;
	}

	public Double getUmidadeIdeal() {
		return umidadeIdeal;
	}

	public void setUmidadeIdeal(Double umidadeIdeal) {
		this.umidadeIdeal = umidadeIdeal;
	}

	public Double getTemperaturaIdeal() {
		return TemperaturaIdeal;
	}

	public void setTemperaturaIdeal(Double temperaturaIdeal) {
		TemperaturaIdeal = temperaturaIdeal;
	}
	
	 
	 @ManyToMany(mappedBy = "plantacao")
	 private Set<Sensor> sensor = new HashSet<>();
	 
	 @ManyToMany
		@JoinTable(
		name = "plantacaoFazenda",
		joinColumns = @JoinColumn(name = "idPlantacao"),
		inverseJoinColumns = @JoinColumn(name = "idFazenda")
		)
		private Set<Fazenda> fazenda = new HashSet<>();
    
}