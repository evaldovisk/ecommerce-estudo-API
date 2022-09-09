package br.com.evaldocorp.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.evaldocorp.ecommerce.dao.PedidoDAO;
import br.com.evaldocorp.ecommerce.model.ItemPedido;
import br.com.evaldocorp.ecommerce.model.Pedido;

@Service
public class PedidoServiceImp implements IPedidoService {

    @Autowired
    private PedidoDAO dao;

    @Override
    public Pedido buscarPeloId(Integer numero) {
        return dao.findById(numero).orElse(null);
    }

    @Override
    public Pedido inserirNovo(Pedido novo) {
        for (ItemPedido item : novo.getItens()) {
            item.setPedido(novo);
        }
        return dao.save(novo);
    }

}
