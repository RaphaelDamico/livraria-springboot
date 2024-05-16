package br.org.serratec.livraria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.livraria.entitties.Usuario;
import br.org.serratec.livraria.respositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	public Usuario findById(Integer id) {
		return usuarioRepository.findById(id).orElse(null);
	}

	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public Usuario update(Integer id, Usuario usuario) {
		Usuario entidade = usuarioRepository.getReferenceById(id);
		updateData(entidade, usuario);
		return usuarioRepository.save(entidade);
	}
	
	private void updateData(Usuario entidade, Usuario usuario) {
		entidade.setUserNome(usuario.getUserNome());
		entidade.setUserEmail(usuario.getUserEmail());
		entidade.setUserPassword(usuario.getUserPassword());
		entidade.setPerfil(usuario.getPerfil());
	}

	public Boolean delete(Integer id) {
		if (usuarioRepository.existsById(id)) {
			usuarioRepository.deleteById(id);
			Usuario usuarioDeletado = usuarioRepository.findById(id).orElse(null);
			if (usuarioDeletado == null) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public long count() {
		return usuarioRepository.count();
	}
}
