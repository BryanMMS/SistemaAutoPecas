package org.example.resource;

import org.example.entities.Endereco;
import org.example.entities.FormaPagamento;
import org.example.services.EnderecoService;
import org.example.services.FormaPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/formasPagamentos")
public class FormaPagamentoResource {

    @Autowired
    private FormaPagamentoService formaPagamentoService;

    @GetMapping
    public List<FormaPagamento> findAll() {

        return formaPagamentoService.buscarTodos();

    }

    @GetMapping("/{id}")
    public ResponseEntity<FormaPagamento> findAll(@PathVariable Long id) {

        return formaPagamentoService.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    public FormaPagamento create(@RequestBody FormaPagamento formaPagamento) {

        return formaPagamentoService.inserir(formaPagamento);

    }

    @PutMapping("/{id}")
    public ResponseEntity<FormaPagamento> Update(@PathVariable Long id, @RequestBody FormaPagamento formaPagamento) {

        return formaPagamentoService.buscarPorId(id).map(existingFormaPagamento -> {
            formaPagamento.setIdFormapagamento(existingFormaPagamento.getIdFormapagamento());

            return ResponseEntity.ok(formaPagamentoService.inserir(formaPagamento));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {

        return formaPagamentoService.buscarPorId(id).map(existingFormaPagamento -> {
                    formaPagamentoService.deletarId(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());

    }

}
