package br.com.avaliacao.attornatus.AvaliacaoBackEnd.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pessoas")
public class Pessoa {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private LocalDate dataDeNascimento;
	private Endereco enderecoPrincipal = null;
	@OneToMany(mappedBy = "pessoa")
	private List<Endereco> enderecos = new ArrayList<Endereco>();
	
	public Pessoa() {
		
	}
	
	public Pessoa( String nome, LocalDate dataDeNascimento, Endereco endereco) {
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
		this.enderecoPrincipal = endereco;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	public void addEndereco (Endereco endereco) {
		enderecos.add(endereco);
	}

	public Endereco getEnderecoPrincipal() {
		return enderecoPrincipal;
	}

	public void setEnderecoPrincipal(Endereco enderecoPrincipal) {
		this.enderecoPrincipal = enderecoPrincipal;
	}
	
}
