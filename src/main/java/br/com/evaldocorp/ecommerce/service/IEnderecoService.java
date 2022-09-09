package br.com.evaldocorp.ecommerce.service;

import java.util.ArrayList;

import br.com.evaldocorp.ecommerce.model.Endereco;

public interface IEnderecoService {
    public Endereco cadastrarEndereco(Endereco novo);

    public Endereco atualizarEndereco(Endereco dados);

    public ArrayList<Endereco> buscarEnderecos();

    public Endereco buscarEnderecoPorId(Integer id);

    public void deletarEndereco(Integer id);
}
