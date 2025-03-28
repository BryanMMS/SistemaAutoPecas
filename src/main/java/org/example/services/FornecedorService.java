package org.example.services;

import org.example.dto.FornecedorDTO;
import org.example.entities.Contato;
import org.example.entities.FormaPagamento;
import org.example.entities.Fornecedor;
import org.example.repositories.FormaPagamentoRepository;
import org.example.repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    public FornecedorRepository fornecedorRepository;

    public List<Fornecedor> buscarTodos() {
        return fornecedorRepository.findAll();
    }

    public Optional<Fornecedor> buscarPorId(Long id) {
        return fornecedorRepository.findById(id);
    }


    public Fornecedor inserir(Fornecedor fornecedor){
        return fornecedorRepository.save(fornecedor);
    }

    public Fornecedor atualizar(Long id, FornecedorDTO objDto) {
        Fornecedor entity = buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado com ID: " + id));

        entity.setRazaoSocial(objDto.getRazaoSocial());
        entity.setNomeFantasia(objDto.getNomeFantasia());
        entity.setCnpj(objDto.getCnpj());
        entity.setStatus_Fornecedor(objDto.getStatus_Fornecedor());
        entity.setNome(objDto.getNome());

        Contato contato = entity.getContatos().get(0);
        contato.setNomeContato(objDto.getNomeContato());
        contato.setEmailContato(objDto.getEmailContato());
        contato.setTelefoneContato(objDto.getTelefoneContato());


        return fornecedorRepository.save(entity);
    }

    public void deletarId(Long id){
        fornecedorRepository.deleteById(id);
    }
}


