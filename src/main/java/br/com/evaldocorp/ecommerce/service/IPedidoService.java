package br.com.evaldocorp.ecommerce.service;

import br.com.evaldocorp.ecommerce.model.Pedido;

public interface IPedidoService {
    public Pedido buscarPeloId(Integer numero);

    public Pedido inserirNovo(Pedido novo);
}
