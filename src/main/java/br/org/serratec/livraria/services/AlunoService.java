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

	public Aluno update(Integer id, Aluno aluno) {
		@SuppressWarnings("deprecation")
		Aluno entidade = alunoRepository.getOne(id);
		updateData(entidade, aluno);
		return alunoRepository.save(entidade);
	}

	public void updateData(Aluno entidade, Aluno aluno) {
		entidade.setNomeAluno(aluno.getNomeAluno());
		entidade.setDataNascimento(aluno.getDataNascimento());
		entidade.setCpfAluno(aluno.getCpfAluno());
		entidade.setLogradouro(aluno.getLogradouro());
		entidade.setNumeroLogradouro(aluno.getNumeroLogradouro());
		entidade.setComplemento(aluno.getComplemento());
		entidade.setBairro(aluno.getBairro());
		entidade.setCidade(aluno.getCidade());
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

	
	
	


