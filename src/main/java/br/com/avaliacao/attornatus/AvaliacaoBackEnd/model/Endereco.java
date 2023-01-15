package br.com.avaliacao.attornatus.AvaliacaoBackEnd.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Endereco {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Logradouro;
	private Long CEP;
	private Long Numero;
	private String Cidade;
	
	public Endereco() {
		
	}
	
	public Endereco(String logradouro, Long cep, Long numero, String cidade) {
		Logradouro = logradouro;
		CEP = cep;
		Numero = numero;
		Cidade = cidade;
	}

	public String getLogradouro() {
		return Logradouro;
	}
	public void setLogradouro(String logradouro) {
		Logradouro = logradouro;
	}
	public long getCEP() {
		return CEP;
	}
	public void setCEP(Long cep) {
		CEP = cep;
	}
	public Long getNumero() {
		return Numero;
	}
	public void setNumero(Long numero) {
		Numero = numero;
	}
	public String getCidade() {
		return Cidade;
	}
	public void setCidade(String cidade) {
		Cidade = cidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
