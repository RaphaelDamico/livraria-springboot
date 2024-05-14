package br.org.serratec.livraria.entitties;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "emprestimo")
public class Emprestimo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emprestimo_id")
	private Integer emprestimoId;
	
	@Column(name = "aluno_matricula")
	private Integer alunoMatricula;
	
	@Column(name = "livro_id")
	private Integer livroId;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_emprestimo")
	private LocalDate dataEmprestimo;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_entrega")
	private LocalDate dataEntrega;
	
	@Column(name = "valor_emprestimo")
	private Integer valorEmprestimo;
	
	@ManyToOne
	@JoinColumn(name = "aluno_matricula")
	private Aluno aluno;

	public Integer getEmprestimoId() {
		return emprestimoId;
	}

	public void setEmprestimoId(Integer emprestimoId) {
		this.emprestimoId = emprestimoId;
	}

	public Integer getAlunoMatricula() {
		return alunoMatricula;
	}

	public void setAlunoMatricula(Integer alunoMatricula) {
		this.alunoMatricula = alunoMatricula;
	}

	public Integer getLivroId() {
		return livroId;
	}

	public void setLivroId(Integer livroId) {
		this.livroId = livroId;
	}

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Integer getValorEmprestimo() {
		return valorEmprestimo;
	}

	public void setValorEmprestimo(Integer valorEmprestimo) {
		this.valorEmprestimo = valorEmprestimo;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	
	
}
