package br.com.avaliacao.attornatus.AvaliacaoBackEnd.controller.form;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import br.com.avaliacao.attornatus.AvaliacaoBackEnd.model.Pessoa;
import br.com.avaliacao.attornatus.AvaliacaoBackEnd.repository.PessoaRepository;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class PessoaForm {

	@NotNull @NotEmpty @Length(min = 5)
	private String nome;
	@NotNull @NotEmpty
	private LocalDate dataDeNascimento;
	
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
	
	public Pessoa atualizar (Long id, PessoaRepository pessoaRepository) {
		Pessoa pessoa = pessoaRepository.getReferenceById(id);
		pessoa.setNome(this.nome);
		pessoa.setDataDeNascimento(this.dataDeNascimento);
		return pessoa;
	}
	public Pessoa cadastrar() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(this.nome);
		pessoa.setDataDeNascimento(this.dataDeNascimento);
		return pessoa;
	}
	
}
