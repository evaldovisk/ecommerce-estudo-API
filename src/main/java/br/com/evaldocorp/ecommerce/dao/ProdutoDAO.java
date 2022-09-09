package br.com.evaldocorp.ecommerce.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import br.com.evaldocorp.ecommerce.model.Produto;

public interface ProdutoDAO extends CrudRepository<Produto, Integer> {

    public ArrayList<Produto> findByOrderByPrecoDesc();

}
