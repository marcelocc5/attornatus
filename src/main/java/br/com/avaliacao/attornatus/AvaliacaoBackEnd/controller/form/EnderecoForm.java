package br.com.avaliacao.attornatus.AvaliacaoBackEnd.controller.form;

import br.com.avaliacao.attornatus.AvaliacaoBackEnd.model.Endereco;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class EnderecoForm {

	@NotNull @NotEmpty
	private String Logradouro;
	@NotNull @NotEmpty
	private Long CEP;
	@NotNull @NotEmpty
	private Long Numero;
	@NotNull @NotEmpty
	private String cidade;
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
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public Endereco cadastrar() {
		Endereco endereco = new Endereco();
		endereco.setCEP(this.CEP);
		endereco.setCidade(this.cidade);
		endereco.setLogradouro(this.Logradouro);
		endereco.setNumero(this.Numero);
		return endereco;
	}
	

}
