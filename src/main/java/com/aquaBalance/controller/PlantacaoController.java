package com.aquaBalance.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.aquaBalance.entities.Plantacao;
import com.aquaBalance.service.PlantacaoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/plantacao")
public class PlantacaoController {

    private final PlantacaoService plantacaoService;

    public PlantacaoController(PlantacaoService plantacaoService) {
        this.plantacaoService = plantacaoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plantacao> getPlantacaoById(@PathVariable Long id) {
        Plantacao plantacao = plantacaoService.getPlantacaoById(id);
        if (plantacao != null) {
            return ResponseEntity.ok(plantacao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Plantacao>> getAllPlantacao() {
        List<Plantacao> plantacao = plantacaoService.getAllPlantacao();
        return ResponseEntity.ok(plantacao);
    }

    @PostMapping("/")
    public ResponseEntity<Plantacao> criarPlantacao(@RequestBody @Valid Plantacao plantacao) {
        Plantacao criarPlantacao = plantacaoService.salvarPlantacao(plantacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(criarPlantacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plantacao> updatePlantacao(@PathVariable Long id, @RequestBody @Valid Plantacao plantacao) {
        Plantacao updatedPlantacao = plantacaoService.updatePlantacao(id, plantacao);
        if (updatedPlantacao != null) {
            return ResponseEntity.ok(updatedPlantacao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlantacao(@PathVariable Long id) {
        boolean deleted = plantacaoService.deletePlantacao(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}