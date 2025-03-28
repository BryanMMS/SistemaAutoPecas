package org.example.resource;

import org.example.entities.Endereco;
import org.example.entities.Fornecedor;
import org.example.services.EnderecoService;
import org.example.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/fornecedores")
public class FornecedorResource {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public List<Fornecedor> findAll() {

        return fornecedorService.buscarTodos();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> findAll(@PathVariable Long id) {

        return fornecedorService.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    public Fornecedor create(@RequestBody Fornecedor fornecedor) {

        return fornecedorService.inserir(fornecedor);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> Update(@PathVariable Long id, @RequestBody Fornecedor fornecedor) {

        return fornecedorService.buscarPorId(id).map(existingFornecedor -> {
            fornecedor.setIdFornecedor(existingFornecedor.getIdFornecedor());

            return ResponseEntity.ok(fornecedorService.inserir(fornecedor));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {

        return fornecedorService.buscarPorId(id).map(existingFornecedor -> {
                    fornecedorService.deletarId(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());

    }

}