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

import br.org.serratec.livraria.entitties.Aluno;

import br.org.serratec.livraria.services.AlunoService;


@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	AlunoService alunoService;

	@GetMapping
	public ResponseEntity<List<Aluno>> findAll() {
		return new ResponseEntity<>(alunoService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Aluno> findById(@PathVariable Integer id) {
		Aluno aluno = alunoService.findById(id);

		if (aluno == null)
			return new ResponseEntity<>(aluno, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(aluno, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Aluno> save(@RequestBody Aluno aluno) {
		return new ResponseEntity<>(alunoService.save(aluno), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Aluno> update(@PathVariable Integer id, @RequestBody Aluno aluno) {
		aluno = alunoService.update(id, aluno);
		return ResponseEntity.ok().body(aluno);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		Boolean deletado = alunoService.delete(id);
		if (deletado)
			return new ResponseEntity<>(HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}

