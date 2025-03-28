package org.example.services;

import org.example.entities.FormaPagamento;
import org.example.entities.Fornecedor;
import org.example.repositories.FormaPagamentoRepository;
import org.example.repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Fornecedor atualizar(Long id, Fornecedor fornecedorAtualizado){
        return  fornecedorRepository.findById(id).map(fornecedor -> {
            fornecedor.setCnpj(fornecedorAtualizado.getCnpj());
            fornecedor.setStatus_Fornecedor(fornecedorAtualizado.getStatus_Fornecedor());
            fornecedor.setNomeFantasia(fornecedorAtualizado.getNomeFantasia());
            fornecedor.setRazaoSocial(fornecedorAtualizado.getRazaoSocial());
            return fornecedorRepository.save(fornecedor);
        }).orElseThrow(() -> new RuntimeException("Fornecedor não encontrado com ID: "+id));

    }

    public void deletarId(Long id){
        fornecedorRepository.deleteById(id);
    }
}
