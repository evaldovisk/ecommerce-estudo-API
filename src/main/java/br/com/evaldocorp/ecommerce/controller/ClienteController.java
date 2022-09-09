package br.com.evaldocorp.ecommerce.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.evaldocorp.ecommerce.model.Cliente;
import br.com.evaldocorp.ecommerce.service.IClienteService;

@RestController
public class ClienteController {

    @Autowired
    private IClienteService service;

    @GetMapping("/clientes")
    public ArrayList<Cliente> listarTodos() {
        return service.buscarTodosClientes();
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> listarPeloID(@PathVariable Integer id) {
        Cliente resposta = service.buscarClientePeloId(id);
        if (resposta != null) {
            ResponseEntity.ok(resposta);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente novo) {
        Cliente resposta = service.cadastrarCLiente(novo);
        if (resposta != null) {
            return ResponseEntity.ok(resposta);
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/clientes")
    public ResponseEntity<Cliente> atualizar(@RequestBody Cliente dados) {
        Cliente resposta = service.atualizarCliente(dados);
        if (resposta != null) {
            return ResponseEntity.ok(resposta);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Cliente> deletar(@PathVariable Integer id) {
        service.deletarCliente(id);
        return ResponseEntity.ok(null);

    }

}
