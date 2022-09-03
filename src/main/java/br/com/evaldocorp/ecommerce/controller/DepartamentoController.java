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
import br.com.evaldocorp.ecommerce.model.Departamento;
import br.com.evaldocorp.ecommerce.service.IDepartamentoService;

@RestController
public class DepartamentoController {

    @Autowired
    private IDepartamentoService service;

    @GetMapping("/departamentos")
    public ArrayList<Departamento> recuperarTodos() {
        return service.buscarTodos();
    }

    @PostMapping("/departamentos")
    public ResponseEntity<Departamento> incluirNovo(@RequestBody Departamento novo) {
        Departamento resultado = service.criarNovo(novo);
        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/departamentos")
    public ResponseEntity<Departamento> alterar(@RequestBody Departamento dados) {
        Departamento resultado = service.atualizarDados(dados);
        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/departamentos/{codigo}")
    public ResponseEntity<Departamento> excluir(@PathVariable Integer codigo) {
        service.excluirDepartamento(codigo);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/departamentos/{codigo}")
    public ResponseEntity<Departamento> recuperarPeloID(@PathVariable Integer codigo) {
        Departamento resposta = service.buscarPeloID(codigo);
        if (resposta != null) {
            return ResponseEntity.ok(resposta);
        }
        return ResponseEntity.notFound().build();
    }
}
