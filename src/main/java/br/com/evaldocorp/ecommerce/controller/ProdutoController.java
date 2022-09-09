package br.com.evaldocorp.ecommerce.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.evaldocorp.ecommerce.model.Produto;
import br.com.evaldocorp.ecommerce.service.IProdutoService;

@RestController
public class ProdutoController {

    @Autowired
    private IProdutoService service;

    @GetMapping("/produtos")
    public ArrayList<Produto> listarTodos() {
        return service.recuperarTodos();
    }

    @GetMapping("/produtos/{codigo}")
    public ResponseEntity<Produto> listarPeloID(@PathVariable Integer codigo) {
        Produto resposta = service.recuperarPeloCodigo(codigo);
        if (resposta != null) {
            return ResponseEntity.ok(resposta);
        }

        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/produtos")
    public ResponseEntity<Produto> inserirNovoProduto(@RequestBody Produto novo) {
        Produto resposta = service.cadastroNovo(novo);
        if (resposta != null) {
            return ResponseEntity.ok(resposta);
        }

        return ResponseEntity.badRequest().build();
    }

}
