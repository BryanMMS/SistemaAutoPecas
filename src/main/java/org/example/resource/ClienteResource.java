package org.example.resource;

import org.example.entities.Cliente;
import org.example.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> findAll() {

        return clienteService.buscarTodos();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findAll(@PathVariable Long id) {

        return clienteService.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    public Cliente create(@RequestBody Cliente cliente) {

        return clienteService.inserir(cliente);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> Update(@PathVariable Long id, @RequestBody Cliente cliente) {

        return clienteService.buscarPorId(id).map(existingCliente -> {
            cliente.setIdcliente(existingCliente.getIdcliente());

            return ResponseEntity.ok(clienteService.inserir(cliente));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {

        return clienteService.buscarPorId(id).map(existingCliente -> {
                    clienteService.deletarId(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());

    }

}
