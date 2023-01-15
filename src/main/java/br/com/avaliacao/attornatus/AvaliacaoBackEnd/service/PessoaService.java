package br.com.avaliacao.attornatus.AvaliacaoBackEnd.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.avaliacao.attornatus.AvaliacaoBackEnd.controller.dto.PessoaDto;
import br.com.avaliacao.attornatus.AvaliacaoBackEnd.controller.form.PessoaForm;
import br.com.avaliacao.attornatus.AvaliacaoBackEnd.model.Endereco;
import br.com.avaliacao.attornatus.AvaliacaoBackEnd.model.Pessoa;
import br.com.avaliacao.attornatus.AvaliacaoBackEnd.repository.PessoaRepository;
import jakarta.validation.Valid;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<Pessoa> findAll(){
		return pessoaRepository.findAll();
	}
	public Optional<Pessoa> findById(Long id){
		return pessoaRepository.findById(id);
	}

	public Optional<Pessoa> findByNome(String nome){
		return pessoaRepository.findByNome(nome);
	}
	
	public ResponseEntity<PessoaDto> atualizar(Long id, @Valid PessoaForm form) {
		Optional<Pessoa> optional = pessoaRepository.findById(id);
		if (optional.isPresent()) {
			Pessoa pessoa = form.atualizar(id, pessoaRepository);
			return ResponseEntity.ok(new PessoaDto(pessoa));
		}else {
			return ResponseEntity.notFound().build();
		}

	}
	public ResponseEntity<PessoaDto> cadastrar(@Valid PessoaForm form, UriComponentsBuilder uriBuilder) {
		Pessoa pessoa = form.cadastrar();
		pessoaRepository.save(pessoa);
		URI uri = uriBuilder.path("/pessoa/{id}").buildAndExpand(pessoa.getId()).toUri();
		return ResponseEntity.created(uri).body(new PessoaDto(pessoa));
	}
	public List<Endereco> findAllEnderecos(Long id) {
		// TODO Auto-generated method stub
		return pessoaRepository.findAllEnderecos(id);
	}
	
}
