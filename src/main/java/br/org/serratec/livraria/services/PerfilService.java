package br.org.serratec.livraria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.livraria.entitties.Perfil;
import br.org.serratec.livraria.respositories.PerfilRepository;

@Service
public class PerfilService {

	@Autowired
	PerfilRepository perfilRepository;

	public List<Perfil> findAll() {
		return perfilRepository.findAll();
	}

	public Perfil findById(Integer id) {
		return perfilRepository.findById(id).orElse(null);
	}

	public Perfil save(Perfil perfil) {
		return perfilRepository.save(perfil);
	}

	public Perfil update(Integer id, Perfil perfil) {
		Perfil entidade = perfilRepository.getReferenceById(id);
		updateData(entidade, perfil);
		return perfilRepository.save(entidade);
	}
	
	private void updateData(Perfil entidade, Perfil perfil) {
		entidade.setNome(perfil.getNome());
		entidade.setDescricao(perfil.getDescricao());
	}

	public Boolean delete(Integer id) {
		if (perfilRepository.existsById(id)) {
			perfilRepository.deleteById(id);
			Perfil perfilDeletado = perfilRepository.findById(id).orElse(null);
			if (perfilDeletado == null) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public long count() {
		return perfilRepository.count();
	}
}
