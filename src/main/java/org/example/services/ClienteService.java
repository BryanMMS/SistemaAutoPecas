package org.example.services;


import org.example.dto.ClienteDTO;
import org.example.dto.FornecedorDTO;
import org.example.entities.Cliente;
import org.example.entities.Contato;
import org.example.entities.Endereco;
import org.example.entities.Fornecedor;
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

    public Cliente atualizar(Long id, ClienteDTO objDto) {
        Cliente entity = buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com ID: " + id));

        entity.setNome(objDto.getNome());
        entity.setCpf(objDto.getCpf());
        entity.setStatuscliente(objDto.getStatuscliente());
        entity.setCpf(objDto.getCpf());
        entity.setDataNascimento(objDto.getDataNascimento());

        Contato contato = entity.getContatos().get(0);
        contato.setNomeContato(objDto.getNomeContato());
        contato.setEmailContato(objDto.getEmailContato());
        contato.setTelefoneContato(objDto.getTelefoneContato());


        Endereco endereco = entity.getEnderecos().get(0);
        endereco.setRua(objDto.getRua());
        endereco.setNumero(objDto.getNumero());
        endereco.setBairro(objDto.getBairro());
        endereco.setCidade(objDto.getCidade());
        endereco.setEstado(objDto.getEstado());
        endereco.setCep(objDto.getCep());
        endereco.setTipoEndereco(objDto.getTipoEndereco());


        return clienteRepository.save(entity);
    }
    public void deletarId(Long id){
        clienteRepository.deleteById(id);
    }

}
