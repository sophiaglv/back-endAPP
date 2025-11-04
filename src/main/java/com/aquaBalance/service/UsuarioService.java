package com.aquaBalance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aquaBalance.entities.Usuario;
import com.aquaBalance.repository.UsuarioRepository;

@Service
public class UsuarioService {


	private final UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public Usuario authenticate(String email, String senha) {
        Usuario user = usuarioRepository.findByEmail(email);

        if (user != null && user.getSenha().equals(senha)) {
            return user;
        }
        return null;
    }

	public List<Usuario> getAllUsuario() {
		return usuarioRepository.findAll();
	}

	public Usuario getUsuarioById(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.orElse(null);
	}

	public Usuario salvarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public Usuario alteraUsuario(Long id, Usuario alteraUsuario) {
		Optional<Usuario> existeUsuario = usuarioRepository.findById(id);
		if (existeUsuario.isPresent()) {
			alteraUsuario.setId(id);
			return usuarioRepository.save(alteraUsuario);
		}
		return null;
	}

	public boolean deleteUsuario(Long id) {
		Optional<Usuario> existeUsuario = usuarioRepository.findById(id);
		if (existeUsuario.isPresent()) {
			usuarioRepository.deleteById(id);
			return true;
		}
		return false;
	}
}