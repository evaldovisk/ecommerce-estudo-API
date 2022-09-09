package br.com.evaldocorp.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.evaldocorp.ecommerce.model.Pedido;
import br.com.evaldocorp.ecommerce.service.IPedidoService;

@RestController
public class PedidoController {

    @Autowired
    private IPedidoService service;

    @GetMapping("/pedidos/{numero}")
    public ResponseEntity<Pedido> recuperar(@PathVariable Integer numero) {
        Pedido resposta = service.buscarPeloId(numero);
        if (resposta != null) {
            return ResponseEntity.ok(resposta);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/pedidos")
    public ResponseEntity<Pedido> inserirNovoPedido(@RequestBody Pedido novo) {
        Pedido resposta = service.inserirNovo(novo);
        if (resposta != null) {

            ResponseEntity.ok(resposta);
        }

        return ResponseEntity.badRequest().build();
    }

}
