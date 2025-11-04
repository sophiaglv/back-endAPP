package com.aquaBalance.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.aquaBalance.entities.Sensor;
import com.aquaBalance.repository.SensorRepository;

@Service
public class SensorService {
    private final SensorRepository sensorRepository;

    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public List<Sensor> getAllSensor() {
        return sensorRepository.findAll();
    }

    public Sensor getSensorById(Long id) {
        Optional<Sensor> sensor = sensorRepository.findById(id);
        return sensor.orElse(null);
    }

    public Sensor salvarSensor( Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    public Sensor updateSensor(Long id, Sensor updatedSensor) {
        Optional<Sensor> existingSensor = sensorRepository.findById(id);
        if (existingSensor.isPresent()) {
            updatedSensor.setId(id);
            return sensorRepository.save(updatedSensor);
        }
        return null;
    }

    public boolean deleteSensor(Long id) {
        Optional<Sensor> existingSensor = sensorRepository.findById(id);
        if (existingSensor.isPresent()) {
            sensorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
