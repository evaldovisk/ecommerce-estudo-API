package br.com.evaldocorp.ecommerce.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.evaldocorp.ecommerce.model.Endereco;
import br.com.evaldocorp.ecommerce.service.IEnderecoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class EnderecoController {

    @Autowired
    private IEnderecoService service;

    @GetMapping("/enderecos")
    public ArrayList<Endereco> listar() {
        return service.buscarEnderecos();
    }

    @GetMapping("/enderecos/{id}")
    public ResponseEntity<Endereco> listarPorId(@PathVariable Integer id) {
        Endereco resposta = service.buscarEnderecoPorId(id);
        if (resposta != null) {
            return ResponseEntity.ok(resposta);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/enderecos")
    public ResponseEntity<Endereco> cadastar(@RequestBody Endereco novo) {
        Endereco resposta = service.cadastrarEndereco(novo);
        if (resposta != null) {
            return ResponseEntity.ok(resposta);
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/enderecos")
    public ResponseEntity<Endereco> atualizar(@RequestBody Endereco novo) {
        Endereco resposta = service.atualizarEndereco(novo);
        if (resposta != null) {
            return ResponseEntity.ok(resposta);
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/enderecos/{id}")
    public ResponseEntity<Endereco> deletar(@PathVariable Integer id) {
        service.deletarEndereco(id);
        return ResponseEntity.ok(null);
    }
}
