package br.org.serratec.livraria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.org.serratec.livraria.entitties.Emprestimo;
import br.org.serratec.livraria.services.EmprestimoService;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

	@Autowired
	EmprestimoService emprestimoService;

	@GetMapping
	public ResponseEntity<List<Emprestimo>> findAll() {
		return new ResponseEntity<>(emprestimoService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Emprestimo> findById(@PathVariable Integer id) {
		Emprestimo emprestimo = emprestimoService.findById(id);

		if (emprestimo == null)
			return new ResponseEntity<>(emprestimo, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(emprestimo, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Emprestimo> save(@RequestBody Emprestimo emprestimo) {
		return new ResponseEntity<>(emprestimoService.save(emprestimo), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Emprestimo> update(@RequestBody Emprestimo emprestimo) {
		return new ResponseEntity<>(emprestimoService.update(emprestimo), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		Boolean deletado = emprestimoService.delete(id);
		if (deletado)
			return new ResponseEntity<>(HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
