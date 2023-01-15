package br.com.avaliacao.attornatus.AvaliacaoBackEnd.controller.dto;

import org.springframework.data.domain.Page;

import br.com.avaliacao.attornatus.AvaliacaoBackEnd.model.Endereco;

public class EnderecoDto {

	private Long id;
	private String Logradouro;
	private Long CEP;
	private Long Numero;
	private String Cidade;
	
	public EnderecoDto (Endereco endereco) {
		this.id=endereco.getId();
		this.Logradouro=endereco.getLogradouro();
		this.CEP=endereco.getCEP();
		this.Numero=endereco.getNumero();
		this.Cidade=endereco.getCidade();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogradouro() {
		return Logradouro;
	}
	public void setLogradouro(String logradouro) {
		Logradouro = logradouro;
	}
	public Long getCEP() {
		return CEP;
	}
	public void setCEP(Long cEP) {
		CEP = cEP;
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
	public static Page<EnderecoDto> converter(Page<Endereco> enderecos){
		return enderecos.map(EnderecoDto::new);
	}
	
}
