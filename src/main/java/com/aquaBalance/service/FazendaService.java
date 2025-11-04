package com.aquaBalance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aquaBalance.entities.Fazenda;
import com.aquaBalance.repository.FazendaRepository;

@Service
public class FazendaService {


	private final FazendaRepository fazendaRepository;

	public FazendaService(FazendaRepository fazendaRepository) {
		this.fazendaRepository = fazendaRepository;
	}

	public List<Fazenda> getAllFazenda() {
		return fazendaRepository.findAll();
	}

	public Fazenda getFazendaById(Long id) {
		Optional<Fazenda> fazenda = fazendaRepository.findById(id);
		return fazenda.orElse(null);
	}

	public Fazenda salvarFazenda(Fazenda fazenda) {
		return fazendaRepository.save(fazenda);
	}

	public Fazenda alteraFazenda(Long id, Fazenda alteraFazenda) {
		Optional<Fazenda> existeFazenda = fazendaRepository.findById(id);
		if (existeFazenda.isPresent()) {
			alteraFazenda.setId(id);
			return fazendaRepository.save(alteraFazenda);
		}
		return null;
	}

	public boolean deleteFazenda(Long id) {
		Optional<Fazenda> existeFazenda = fazendaRepository.findById(id);
		if (existeFazenda.isPresent()) {
			fazendaRepository.deleteById(id);
			return true;
		}
		return false;
	}
}