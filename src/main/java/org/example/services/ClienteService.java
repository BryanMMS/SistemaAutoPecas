package org.example.services;


import org.example.entities.Cliente;
import org.example.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    public ClienteRepository clienteRepository;

    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id){
        return clienteRepository.findById(id);
    }

    public Cliente inserir(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente atualizar(Long id, Cliente clienteAtualizado){
        return clienteRepository.findById(id).map(cliente -> {
           cliente.setCpf(clienteAtualizado.getCpf());
            cliente.setNome(clienteAtualizado.getNome());
            cliente.setDataNascimento(clienteAtualizado.getDataNascimento());
            cliente.setStatuscliente(clienteAtualizado.getStatuscliente());
            return clienteRepository.save(cliente);
        }).orElseThrow(() ->new RuntimeException("Cliente não encontrado com ID: " +id));
    }

    public void deletarId(Long id){
        clienteRepository.deleteById(id);
    }

}
