package br.com.evaldocorp.ecommerce.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.evaldocorp.ecommerce.dao.ClienteDAO;
import br.com.evaldocorp.ecommerce.model.Cliente;

@Service
public class ClienteServiceImp implements IClienteService {

    @Autowired
    private ClienteDAO dao;

    @Override
    public ArrayList<Cliente> buscarTodosClientes() {
        return (ArrayList<Cliente>) dao.findAll();
    }

    @Override
    public Cliente buscarClientePeloId(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public Cliente cadastrarCLiente(Cliente novo) {
        return dao.save(novo);
    }

    @Override
    public Cliente atualizarCliente(Cliente dados) {
        if (dados.getId() != null && dados.getNome() != null) {
            return dao.save(dados);
        }

        return null;
    }

    @Override
    public void deletarCliente(Integer id) {
        dao.deleteById(id);
    }

}
