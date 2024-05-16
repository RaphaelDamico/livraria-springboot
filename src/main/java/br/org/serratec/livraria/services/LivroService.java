package br.org.serratec.livraria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.livraria.entitties.Livro;
import br.org.serratec.livraria.entitties.Perfil;
import br.org.serratec.livraria.respositories.LivroRepository;

@Service
public class LivroService {

	@Autowired
	LivroRepository livroRepository;
	
	public List<Livro> findAll(){
		return livroRepository.findAll();
	}
	
	public Livro findById(Integer id) {
		return livroRepository.findById(id).orElse(null);
	}
	
	public Livro save(Livro livro) {
		return livroRepository.save(livro);
	}
	
	public Livro update(Integer id, Livro livro) {
		Livro entidade = livroRepository.getReferenceById(id);
		updateData(entidade, livro);
		return livroRepository.save(entidade);
	}
	
	private void updateData(Livro entidade, Livro livro) {
		entidade.setNomeLivro(livro.getNomeLivro());
		entidade.setNomeAutor(livro.getNomeAutor());
		entidade.setDataLancamento(livro.getDataLancamento());
		entidade.setCodigoIsbn(livro.getCodigoIsbn());
	}
	
	public Boolean delete(Integer id) {
		if (livroRepository.existsById(id)) {
			livroRepository.deleteById(id);
			Livro livroDeletado = livroRepository.findById(id).orElse(null);
			if (livroDeletado == null) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public long count() {
		return livroRepository.count();
	}
}
