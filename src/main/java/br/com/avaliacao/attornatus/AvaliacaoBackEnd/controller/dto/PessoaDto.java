package br.com.avaliacao.attornatus.AvaliacaoBackEnd.controller.dto;

import java.time.LocalDate;

import org.springframework.data.domain.Page;

import br.com.avaliacao.attornatus.AvaliacaoBackEnd.model.Pessoa;

public class PessoaDto {

	private Long id;
	private String nome;
	private LocalDate dataDeNascimento;
	
	public PessoaDto(Pessoa pessoa) {
		this.id=pessoa.getId();
		this.nome=pessoa.getNome();
		this.dataDeNascimento=pessoa.getDataDeNascimento();
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
	public static Page<PessoaDto> converter(Page<Pessoa> pessoas){
		return pessoas.map(PessoaDto::new);
	}
}
