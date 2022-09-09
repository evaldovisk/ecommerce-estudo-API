package br.com.evaldocorp.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.evaldocorp.ecommerce.model.Cliente;

public interface ClienteDAO extends CrudRepository<Cliente, Integer> {

}
