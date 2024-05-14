package br.org.serratec.livraria.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.org.serratec.livraria.entitties.Aluno;
import br.org.serratec.livraria.respositories.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	AlunoRepository alunoRepository;

	public List<Aluno> findAll() {
		return alunoRepository.findAll();
	}

	public Aluno findById(Integer id) {
		return alunoRepository.findById(id).orElse(null);
	}

	public Aluno save(Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	public Aluno update(Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	public Boolean delete(Integer id) {
		if (alunoRepository.existsById(id)) {
			alunoRepository.deleteById(id);
			Aluno alunoDeletado = alunoRepository.findById(id).orElse(null);
			if (alunoDeletado == null) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public long count() {
		return alunoRepository.count();
	}
}

	
	
	


