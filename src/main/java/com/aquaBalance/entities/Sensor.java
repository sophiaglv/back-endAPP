package com.aquaBalance.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "sensor")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "TipoSensor")
    private String tipoSensor;

    @Column(name = "codigo")
    private int codigo;

    @Column(name = "localizacao")
    private String localizacao;
    
	public Sensor() {
		super();
	}

	public Sensor(Long id, String tipoSensor, int codigo, String localizacao) {
		super();
		this.id = id;
		this.tipoSensor = tipoSensor;
		this.codigo = codigo;
		this.localizacao = localizacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoSensor() {
		return tipoSensor;
	}

	public void setTipoSensor(String tipoSensor) {
		this.tipoSensor = tipoSensor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}   
    
	@ManyToMany
	@JoinTable(
	name = "sensorPlantacao",
	joinColumns = @JoinColumn(name = "idSensor"),
	inverseJoinColumns = @JoinColumn(name = "idPlantacao")
	)
	private Set<Plantacao> plantacao = new HashSet<>();
	
}