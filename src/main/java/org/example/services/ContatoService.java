package org.example.services;


import org.example.entities.Cliente;
import org.example.entities.Contato;
import org.example.repositories.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    @Autowired
    public ContatoRepository contatoRepository;

    public List<Contato> buscarTodos() {
        return contatoRepository.findAll();
    }

    public Optional<Contato> buscarPorId(Long id) {
        return contatoRepository.findById(id);
    }


    public Contato inserir(Contato contato){
        return contatoRepository.save(contato);
    }

    public Contato atualizar(Long id, Contato contatoAtualizado){
        return  contatoRepository.findById(id).map(contato -> {
            contato.setEmailContato(contatoAtualizado.getEmailContato());
            contato.setNomeContato(contatoAtualizado.getNomeContato());
            contato.setTelefoneContato(contatoAtualizado.getTelefoneContato());
            return contatoRepository.save(contato);
        }).orElseThrow(() -> new RuntimeException("Contato não encontrado com ID: "+id));

    }

    public void deletarId(Long id){
        contatoRepository.deleteById(id);
    }
}
