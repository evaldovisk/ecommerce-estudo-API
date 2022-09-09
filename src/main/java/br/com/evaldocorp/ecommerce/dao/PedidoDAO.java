package br.com.evaldocorp.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.evaldocorp.ecommerce.model.Pedido;

public interface PedidoDAO extends CrudRepository<Pedido, Integer> {

}
