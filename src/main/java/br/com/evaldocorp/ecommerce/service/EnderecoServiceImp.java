package br.com.evaldocorp.ecommerce.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.evaldocorp.ecommerce.dao.EnderecoDAO;
import br.com.evaldocorp.ecommerce.model.Endereco;

@Service
public class EnderecoServiceImp implements IEnderecoService {

    @Autowired
    private EnderecoDAO dao;

    @Override
    public Endereco cadastrarEndereco(Endereco novo) {
        return dao.save(novo);
    }

    @Override
    public Endereco atualizarEndereco(Endereco dados) {
        if (dados.getId() != null && dados.getTipo() != null) {
            return dao.save(dados);
        }
        return null;
    }

    @Override
    public ArrayList<Endereco> buscarEnderecos() {
        return (ArrayList<Endereco>) dao.findAll();
    }

    @Override
    public Endereco buscarEnderecoPorId(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public void deletarEndereco(Integer id) {
        dao.deleteById(id);
    }

}
