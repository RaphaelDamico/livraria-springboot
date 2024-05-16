package br.org.serratec.livraria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.livraria.entitties.Emprestimo;
import br.org.serratec.livraria.respositories.EmprestimoRepository;

@Service
public class EmprestimoService {

	@Autowired
	EmprestimoRepository emprestimoRepository;

	public List<Emprestimo> findAll() {
		return emprestimoRepository.findAll();
	}

	public Emprestimo findById(Integer id) {
		return emprestimoRepository.findById(id).orElse(null);
	}

	public Emprestimo save(Emprestimo emprestimo) {
		return emprestimoRepository.save(emprestimo);
	}

	public Emprestimo update(Integer id, Emprestimo emprestimo) {
		Emprestimo entidade = emprestimoRepository.getReferenceById(id);
		updateData(entidade, emprestimo);
		return emprestimoRepository.save(entidade);
	}
	
	private void updateData(Emprestimo entidade, Emprestimo emprestimo) {
		entidade.setDataEmprestimo(emprestimo.getDataEmprestimo());
		entidade.setDataEntrega(emprestimo.getDataEntrega());
		entidade.setValorEmprestimo(emprestimo.getValorEmprestimo());
		entidade.setAluno(emprestimo.getAluno());
		entidade.setLivro(emprestimo.getLivro());
	}

	public Boolean delete(Integer id) {
		if (emprestimoRepository.existsById(id)) {
			emprestimoRepository.deleteById(id);
			Emprestimo EmprestimoDeletado = emprestimoRepository.findById(id).orElse(null);
			if (EmprestimoDeletado == null) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public long count() {
		return emprestimoRepository.count();
	}
}
