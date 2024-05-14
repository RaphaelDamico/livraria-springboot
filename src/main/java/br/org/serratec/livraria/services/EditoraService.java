package br.org.serratec.livraria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.livraria.entitties.Editora;
import br.org.serratec.livraria.respositories.EditoraRepository;

@Service
public class EditoraService {

	@Autowired
	EditoraRepository editoraRepository;

	public List<Editora> findAll() {
		return editoraRepository.findAll();
	}

	public Editora findById(Integer id) {
		return editoraRepository.findById(id).orElse(null);
	}

	public Editora save(Editora editora) {
		return editoraRepository.save(editora);
	}

	public Editora update(Editora editora) {
		return editoraRepository.save(editora);
	}

	public Boolean delete(Integer id) {
		if (editoraRepository.existsById(id)) {
			editoraRepository.deleteById(id);
			Editora editoraDeletado = editoraRepository.findById(id).orElse(null);
			if (editoraDeletado == null) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public long count() {
		return editoraRepository.count();
	}
}
