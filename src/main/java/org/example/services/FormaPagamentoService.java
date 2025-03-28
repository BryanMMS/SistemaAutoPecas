package org.example.services;

import org.example.entities.Endereco;
import org.example.entities.FormaPagamento;
import org.example.repositories.EnderecoRepository;
import org.example.repositories.FormaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormaPagamentoService {

    @Autowired
    public FormaPagamentoRepository formaPagamentoRepository;

    public List<FormaPagamento> buscarTodos() {
        return formaPagamentoRepository.findAll();
    }

    public Optional<FormaPagamento> buscarPorId(Long id) {
        return formaPagamentoRepository.findById(id);
    }


    public FormaPagamento inserir(FormaPagamento formaPagamento){
        return formaPagamentoRepository.save(formaPagamento);
    }

    public FormaPagamento atualizar(Long id, FormaPagamento formaPagamentoAtualizado){
        return  formaPagamentoRepository.findById(id).map(formaPagamento -> {
            formaPagamento.setDescricao(formaPagamentoAtualizado.getDescricao());
            formaPagamento.setTipo(formaPagamentoAtualizado.getTipo());
            formaPagamento.setStatuspagamento(formaPagamentoAtualizado.getStatuspagamento());
            return formaPagamentoRepository.save(formaPagamento);
        }).orElseThrow(() -> new RuntimeException("Forma de pagamento não encontrado com ID: "+id));

    }

    public void deletarId(Long id){
        formaPagamentoRepository.deleteById(id);
    }
}
