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

import com.aquaBalance.entities.Usuario;
import com.aquaBalance.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	private final UsuarioService usuarioService;

	@PostMapping("/auth")
	public ResponseEntity<Usuario> authenticate(@RequestBody Usuario usuarioDetails) {
		Usuario authenticatedUser = usuarioService.authenticate(usuarioDetails.getEmail(), usuarioDetails.getSenha());

		if (authenticatedUser != null) {
			authenticatedUser.setSenha(null);
			return ResponseEntity.ok(authenticatedUser);
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}


		public UsuarioController(UsuarioService usuarioService) {
			this.usuarioService = usuarioService;
		}

		@GetMapping("/{id}")
		public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
			Usuario usuario = usuarioService.getUsuarioById(id);
			if (usuario != null) {
				return ResponseEntity.ok(usuario);
			} else {
				return ResponseEntity.notFound().build();
			}
		}

		@GetMapping("/")
		public ResponseEntity<List<Usuario>> getAllUsuario() {
			List<Usuario> usuario = usuarioService.getAllUsuario();
			return ResponseEntity.ok(usuario);
		}

		@PostMapping("/cadastro")
		public ResponseEntity<Usuario> criarUsuario(@RequestBody @Valid Usuario usuario) {
			Usuario criarUsuario = usuarioService.salvarUsuario(usuario);
			return ResponseEntity.status(HttpStatus.CREATED).body(criarUsuario);
		}

		@PutMapping("/{id}")
		public ResponseEntity<Usuario> alteraUsuario(@PathVariable Long id, @RequestBody @Valid Usuario usuario) {
			Usuario alteraUsuario = usuarioService.alteraUsuario(id, usuario);
			if (alteraUsuario != null) {
				return ResponseEntity.ok(alteraUsuario);
			} else {
				return ResponseEntity.notFound().build();
			}
		}

		@DeleteMapping("/{id}")
		public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
			boolean deleted = usuarioService.deleteUsuario(id);
			if (deleted) {
				return ResponseEntity.noContent().build();
			} else {
				return ResponseEntity.notFound().build();
			}
		}
	}