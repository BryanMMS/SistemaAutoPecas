package org.example.resource;

import org.example.entities.Contato;
import org.example.entities.Endereco;
import org.example.services.ContatoService;
import org.example.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public List<Endereco> findAll() {

        return enderecoService.buscarTodos();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> findAll(@PathVariable Long id) {

        return enderecoService.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    public Endereco create(@RequestBody Endereco endereco) {

        return enderecoService.inserir(endereco);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> Update(@PathVariable Long id, @RequestBody Endereco endereco) {

        return enderecoService.buscarPorId(id).map(existingEndereco -> {
            endereco.setIdEndereco(existingEndereco.getIdEndereco());

            return ResponseEntity.ok(enderecoService.inserir(endereco));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {

        return enderecoService.buscarPorId(id).map(existingEndereco -> {
                    enderecoService.deletarId(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());

    }

}
