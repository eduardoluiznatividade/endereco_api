package br.edu.infnet.apiendereco.model.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.apiendereco.model.domain.Endereco;

public interface EnderecoRepository extends CrudRepository<Endereco, Integer>{

	Endereco findByCep(String cep);
	
}
