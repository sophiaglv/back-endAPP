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

import com.aquaBalance.entities.Cultura;
import com.aquaBalance.service.CulturaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cultura")
public class CulturaController {

	private final CulturaService culturaService;

	public CulturaController(CulturaService culturaService) {
		this.culturaService = culturaService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cultura> getCulturaById(@PathVariable Long id) {
		Cultura cultura = culturaService.getCulturaById(id);
		if (cultura != null) {
			return ResponseEntity.ok(cultura);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Cultura>> getAllCultura() {
		List<Cultura> cultura = culturaService.getAllCultura();
		return ResponseEntity.ok(cultura);
	}

	@PostMapping("/")
	public ResponseEntity<Cultura> criarCultura(@RequestBody @Valid Cultura cultura) {
		Cultura criarCultura = culturaService.salvarCultura(cultura);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarCultura);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cultura> alteraCultura(@PathVariable Long id, @RequestBody @Valid Cultura cultura) {
		Cultura alteraCultura = culturaService.alteraCultura(id, cultura);
		if (alteraCultura != null) {
			return ResponseEntity.ok(alteraCultura);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCultura(@PathVariable Long id) {
		boolean deleted = culturaService.deleteCultura(id);
		if (deleted) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}