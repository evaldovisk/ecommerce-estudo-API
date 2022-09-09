package br.com.evaldocorp.ecommerce.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.evaldocorp.ecommerce.dao.ProdutoDAO;
import br.com.evaldocorp.ecommerce.model.Produto;

@Service
public class ProdutoServiceImp implements IProdutoService {

    @Autowired
    private ProdutoDAO dao;

    @Override
    public ArrayList<Produto> recuperarTodos() {

        return (ArrayList<Produto>) dao.findByOrderByPrecoDesc();
    }

    @Override
    public Produto recuperarPeloCodigo(Integer codigo) {

        return dao.findById(codigo).orElse(null);
    }

    @Override
    public Produto cadastroNovo(Produto novo) {
        return dao.save(novo);
    }

}
