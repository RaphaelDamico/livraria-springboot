package br.org.serratec.livraria.entitties;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "perfil")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "perfilId", scope = Perfil.class)
public class Perfil {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "perfil_id")
	private Integer perfilId;

	@Column(name = "nome")
	private String nome;

	@Column(name = "descricao")
	private String descricao;

	@OneToMany(mappedBy = "perfil")
	private List<Usuario> usuario;

	public Perfil() {

	}

	public Perfil(Integer perfilId, String nome, String descricao, List<Usuario> usuario) {
		this.perfilId = perfilId;
		this.nome = nome;
		this.descricao = descricao;
		this.usuario = usuario;
	}

	public Integer getPerfilId() {
		return perfilId;
	}

	public void setPerfilId(Integer perfilId) {
		this.perfilId = perfilId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

}
