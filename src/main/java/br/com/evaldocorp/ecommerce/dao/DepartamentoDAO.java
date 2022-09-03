package br.com.evaldocorp.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.evaldocorp.ecommerce.model.Departamento;

public interface DepartamentoDAO extends CrudRepository<Departamento, Integer> {

}
