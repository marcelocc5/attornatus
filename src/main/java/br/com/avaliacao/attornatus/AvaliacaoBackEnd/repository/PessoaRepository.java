package br.com.avaliacao.attornatus.AvaliacaoBackEnd.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.avaliacao.attornatus.AvaliacaoBackEnd.model.Endereco;
import br.com.avaliacao.attornatus.AvaliacaoBackEnd.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

	Optional<Pessoa> findByNome (String nome);

	@Query(value = "SELECT p.enderecoprincipal,enderecos FROM pessoa p WHERE p.id =:id", nativeQuery = true)
	List<Endereco> findAllEnderecos(Long id);
}
