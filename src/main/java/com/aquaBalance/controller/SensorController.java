package com.aquaBalance.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.aquaBalance.entities.Sensor;
import com.aquaBalance.service.SensorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/sensores")
public class SensorController {

    private final SensorService sensorService;

    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sensor> getSensorById(@PathVariable Long id) {
        Sensor sensor = sensorService.getSensorById(id);
        if (sensor != null) {
            return ResponseEntity.ok(sensor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Sensor>> getAllSensor() {
        List<Sensor> sensor = sensorService.getAllSensor();
        return ResponseEntity.ok(sensor);
    }

    @PostMapping("/")
    public ResponseEntity<Sensor> criarSensor(@RequestBody @Valid Sensor sensor) {
        Sensor criarSensor = sensorService.salvarSensor(sensor);
        return ResponseEntity.status(HttpStatus.CREATED).body(criarSensor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sensor> updateSensor(@PathVariable Long id, @RequestBody @Valid Sensor sensor) {
        Sensor updatedSensor = sensorService.updateSensor(id, sensor);
        if (updatedSensor != null) {
            return ResponseEntity.ok(updatedSensor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSensor(@PathVariable Long id) {
        boolean deleted = sensorService.deleteSensor(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}