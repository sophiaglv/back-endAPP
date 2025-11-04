package com.aquaBalance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aquaBalance.entities.Cultura;
import com.aquaBalance.repository.CulturaRepository;

@Service
public class CulturaService {


	private final CulturaRepository culturaRepository;

	public CulturaService(CulturaRepository culturaRepository) {
		this.culturaRepository = culturaRepository;
	}

	public List<Cultura> getAllCultura() {
		return culturaRepository.findAll();
	}

	public Cultura getCulturaById(Long id) {
		Optional<Cultura> cultura = culturaRepository.findById(id);
		return cultura.orElse(null);
	}

	public Cultura salvarCultura(Cultura cultura) {
		return culturaRepository.save(cultura);
	}

	public Cultura alteraCultura(Long id, Cultura alteraCultura) {
		Optional<Cultura> existeCultura = culturaRepository.findById(id);
		if (existeCultura.isPresent()) {
			alteraCultura.setId(id);
			return culturaRepository.save(alteraCultura);
		}
		return null;
	}

	public boolean deleteCultura(Long id) {
		Optional<Cultura> existeCultura = culturaRepository.findById(id);
		if (existeCultura.isPresent()) {
			culturaRepository.deleteById(id);
			return true;
		}
		return false;
	}
}