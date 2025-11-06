package com.aquaBalance.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "sensor")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tipoSensor")
    private String tipoSensor;

    @Column(name = "codigo")
    private int codigo;

    @ManyToOne
    @JoinColumn(name = "localizacao", nullable = false)
    private Plantacao localizacao;
    
	public Sensor() {
		super();
	}

	public Sensor(Long id, String tipoSensor, int codigo, Plantacao localizacao) {
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

	public Plantacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Plantacao localizacao) {
		this.localizacao = localizacao;
	}   
	
}