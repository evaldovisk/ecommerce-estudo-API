package br.com.evaldocorp.ecommerce.service;

import java.util.ArrayList;

import br.com.evaldocorp.ecommerce.model.Cliente;

public interface IClienteService {
    public ArrayList<Cliente> buscarTodosClientes();

    public Cliente buscarClientePeloId(Integer id);

    public Cliente cadastrarCLiente(Cliente novo);

    public Cliente atualizarCliente(Cliente dados);

    public void deletarCliente(Integer id);

}
