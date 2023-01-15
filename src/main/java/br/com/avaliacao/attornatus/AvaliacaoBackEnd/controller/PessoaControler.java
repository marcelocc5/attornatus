package br.com.avaliacao.attornatus.AvaliacaoBackEnd.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.avaliacao.attornatus.AvaliacaoBackEnd.controller.dto.EnderecoDto;
import br.com.avaliacao.attornatus.AvaliacaoBackEnd.controller.dto.PessoaDto;
import br.com.avaliacao.attornatus.AvaliacaoBackEnd.controller.form.EnderecoForm;
import br.com.avaliacao.attornatus.AvaliacaoBackEnd.controller.form.PessoaForm;
import br.com.avaliacao.attornatus.AvaliacaoBackEnd.model.Endereco;
import br.com.avaliacao.attornatus.AvaliacaoBackEnd.model.Pessoa;
import br.com.avaliacao.attornatus.AvaliacaoBackEnd.service.EnderecoService;
import br.com.avaliacao.attornatus.AvaliacaoBackEnd.service.PessoaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pessoa")
public class PessoaControler {

	@Autowired
	PessoaService pessoaService;
	
	@Autowired
	EnderecoService enderecoService;
	
	@GetMapping
	public List<Pessoa> findAll(){
		return pessoaService.findAll();
	}
	
	@GetMapping("/{id}/enderecos")
	public List<Endereco> findAllEnderecos(@PathVariable Long id){
		return pessoaService.findAllEnderecos(id);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> getPessoaById (@PathVariable Long id){
		Optional<Pessoa> pessoaOptional = pessoaService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(pessoaOptional.get());
	}
	
	@GetMapping("/{nome}")
	public ResponseEntity<Pessoa> getPessoaByNome (@PathVariable String nome){
		Optional<Pessoa> pessoaOptional = pessoaService.findByNome(nome);
		return ResponseEntity.status(HttpStatus.OK).body(pessoaOptional.get());
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<PessoaDto> cadastrar (@RequestBody @Valid PessoaForm form, UriComponentsBuilder uriBuilder){
		return pessoaService.cadastrar(form, uriBuilder);
	}
	
	@PostMapping("/{id}/enderecos")
	@Transactional
	public ResponseEntity<EnderecoDto> cadastrarEndereco (@RequestBody @Valid EnderecoForm form, UriComponentsBuilder uriBuilder, Long id){
		return enderecoService.cadastrar(form, uriBuilder, id);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PessoaDto> atualizar(@PathVariable Long id,@RequestBody @Valid PessoaForm form){
		return pessoaService.atualizar(id,form);
	}
	@PutMapping("/{id}/enderecos/{id2}")
	@Transactional
	public ResponseEntity<EnderecoDto> atualizarEnderecoPrincipal(@PathVariable Long id,@PathVariable Long id2){
		return enderecoService.atualizarPrincipal(id,id2);
	}
}
