package com.aquaBalance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aquaBalance.entities.Sensor;

public interface SensorRepository extends JpaRepository<Sensor, Long>{

}
