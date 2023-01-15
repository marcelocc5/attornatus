package br.com.avaliacao.attornatus.AvaliacaoBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.avaliacao.attornatus.AvaliacaoBackEnd.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

}
