package com.aquaBalance.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.aquaBalance.entities.Plantacao;
import com.aquaBalance.repository.PlantacaoRepository;

@Service
public class PlantacaoService {
    private final PlantacaoRepository plantacaoRepository;

    public PlantacaoService(PlantacaoRepository plantacaoRepository) {
        this.plantacaoRepository = plantacaoRepository;
    }

    public List<Plantacao> getAllPlantacao() {
        return plantacaoRepository.findAll();
    }

    public Plantacao getPlantacaoById(Long id) {
        Optional<Plantacao> plantacao = plantacaoRepository.findById(id);
        return plantacao.orElse(null);
    }

    public Plantacao salvarPlantacao( Plantacao plantacao) {
        return plantacaoRepository.save(plantacao);
    }

    public Plantacao updatePlantacao(Long id, Plantacao updatedPlantacao) {
        Optional<Plantacao> existingPlantacao = plantacaoRepository.findById(id);
        if (existingPlantacao.isPresent()) {
            updatedPlantacao.setId(id);
            return plantacaoRepository.save(updatedPlantacao);
        }
        return null;
    }

    public boolean deletePlantacao(Long id) {
        Optional<Plantacao> existingPlantacao = plantacaoRepository.findById(id);
        if (existingPlantacao.isPresent()) {
            plantacaoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}