package br.com.evaldocorp.ecommerce.service;

import java.util.ArrayList;

import br.com.evaldocorp.ecommerce.model.Departamento;

public interface IDepartamentoService {
    public Departamento criarNovo(Departamento novo);

    public Departamento atualizarDados(Departamento dados);

    public ArrayList<Departamento> buscarTodos();

    public Departamento buscarPeloID(Integer id);

    public void excluirDepartamento(Integer id);
}
