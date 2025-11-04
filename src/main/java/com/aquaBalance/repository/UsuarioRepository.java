package com.aquaBalance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aquaBalance.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Usuario findByEmail(String email);
}