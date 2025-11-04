package com.aquaBalance.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aquaBalance.entities.Fazenda;
import com.aquaBalance.service.FazendaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/propriedades")
public class FazendaController {

	private final FazendaService fazendaService;

	public FazendaController(FazendaService fazendaService) {
		this.fazendaService = fazendaService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Fazenda> getFazendaById(@PathVariable Long id) {
		Fazenda fazenda = fazendaService.getFazendaById(id);
		if (fazenda != null) {
			return ResponseEntity.ok(fazenda);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Fazenda>> getAllFazenda() {
		List<Fazenda> fazenda = fazendaService.getAllFazenda();
		return ResponseEntity.ok(fazenda);
	}

	@PostMapping("/")
	public ResponseEntity<Fazenda> criarFazenda(@RequestBody @Valid Fazenda fazenda) {
		Fazenda criarFazenda = fazendaService.salvarFazenda(fazenda);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarFazenda);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Fazenda> alteraFazenda(@PathVariable Long id, @RequestBody @Valid Fazenda fazenda) {
		Fazenda alteraFazenda = fazendaService.alteraFazenda(id, fazenda);
		if (alteraFazenda != null) {
			return ResponseEntity.ok(alteraFazenda);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteFazenda(@PathVariable Long id) {
		boolean deleted = fazendaService.deleteFazenda(id);
		if (deleted) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}