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

	public Emprestimo update(Emprestimo emprestimo) {
		return emprestimoRepository.save(emprestimo);
	}

	public Boolean delete(Integer id) {
		if (emprestimoRepository.existsById(id)) {
			emprestimoRepository.deleteById(id);
			Emprestimo emprestimoDeletado = emprestimoRepository.findById(id).orElse(null);
			if (emprestimoDeletado == null) {
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
