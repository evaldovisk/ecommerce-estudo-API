package br.com.evaldocorp.ecommerce.service;

import java.util.ArrayList;

import br.com.evaldocorp.ecommerce.model.Produto;

public interface IProdutoService {
    public ArrayList<Produto> recuperarTodos();

    public Produto recuperarPeloCodigo(Integer codigo);

    public Produto cadastroNovo(Produto novo);
}
