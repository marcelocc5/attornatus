package br.com.avaliacao.attornatus.AvaliacaoBackEnd.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.avaliacao.attornatus.AvaliacaoBackEnd.controller.dto.EnderecoDto;
import br.com.avaliacao.attornatus.AvaliacaoBackEnd.controller.form.EnderecoForm;
import br.com.avaliacao.attornatus.AvaliacaoBackEnd.model.Endereco;
import br.com.avaliacao.attornatus.AvaliacaoBackEnd.model.Pessoa;
import br.com.avaliacao.attornatus.AvaliacaoBackEnd.repository.EnderecoRepository;
import br.com.avaliacao.attornatus.AvaliacaoBackEnd.repository.PessoaRepository;
import jakarta.validation.Valid;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;

	public ResponseEntity<EnderecoDto> cadastrar(@Valid EnderecoForm form, UriComponentsBuilder uriBuilder, Long id) {
		Pessoa pessoa = pessoaRepository.getReferenceById(id);
		if (pessoa.getEnderecoPrincipal()== null) {
			Endereco endereco = form.cadastrar();
			pessoa.setEnderecoPrincipal(endereco);
			enderecoRepository.save(endereco);
			URI uri = uriBuilder.path("/pessoa/"+pessoa.getId()+"/endereco/{id}").buildAndExpand(endereco.getId()).toUri();
			return ResponseEntity.created(uri).body(new EnderecoDto(endereco));
		}else {
			Endereco endereco = form.cadastrar();
			pessoa.addEndereco(endereco);
			enderecoRepository.save(endereco);
			URI uri = uriBuilder.path("/pessoa/"+pessoa.getId()+"/endereco/{id}").buildAndExpand(endereco.getId()).toUri();
			return ResponseEntity.created(uri).body(new EnderecoDto(endereco));
		}

	}

	public ResponseEntity<EnderecoDto> atualizarPrincipal(Long id, Long id2) {
		Pessoa pessoa = pessoaRepository.getReferenceById(id);
		Endereco endereco = enderecoRepository.getReferenceById(id2);
		pessoa.addEndereco(pessoa.getEnderecoPrincipal());
		pessoa.setEnderecoPrincipal(endereco);
		return ResponseEntity.ok(new EnderecoDto(endereco));
		
	}



}
