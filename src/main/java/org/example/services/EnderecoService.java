package org.example.services;

import org.example.entities.Contato;
import org.example.entities.Endereco;
import org.example.repositories.ContatoRepository;
import org.example.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    public EnderecoRepository enderecoRepository;

    public List<Endereco> buscarTodos() {
        return enderecoRepository.findAll();
    }

    public Optional<Endereco> buscarPorId(Long id) {
        return enderecoRepository.findById(id);
    }


    public Endereco inserir(Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    public Endereco atualizar(Long id, Endereco enderecoAtualizado){
        return  enderecoRepository.findById(id).map(endereco -> {
            endereco.setBairro(enderecoAtualizado.getBairro());
            endereco.setCep(enderecoAtualizado.getCep());
            endereco.setTipoEndereco(enderecoAtualizado.getTipoEndereco());
            endereco.setCidade(enderecoAtualizado.getCidade());
            endereco.setEstado(enderecoAtualizado.getEstado());
            endereco.setNumero(enderecoAtualizado.getNumero());
            endereco.setRua(enderecoAtualizado.getRua());
            return enderecoRepository.save(endereco);
        }).orElseThrow(() -> new RuntimeException("Endereço não encontrado com ID: "+id));

    }

    public void deletarId(Long id){
        enderecoRepository.deleteById(id);
    }
}
