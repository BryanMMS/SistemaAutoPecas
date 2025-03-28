package org.example.services;

import org.example.entities.Fornecedor;
import org.example.entities.Produto;
import org.example.repositories.FornecedorRepository;
import org.example.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    public ProdutoRepository produtoRepository;

    public List<Produto> buscarTodos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }


    public Produto inserir(Produto produto){
        return produtoRepository.save(produto);
    }

    public Produto atualizar(Long id, Produto produtoAtualizado){
        return  produtoRepository.findById(id).map(produto -> {
            produto.setDescricao(produtoAtualizado.getDescricao());
            produto.setEstoque(produtoAtualizado.getEstoque());
            produto.setNome(produtoAtualizado.getNome());
            produto.setPrecoCusto(produtoAtualizado.getPrecoCusto());
            produto.setPrecoVenda(produtoAtualizado.getPrecoVenda());
            return produtoRepository.save(produto);
        }).orElseThrow(() -> new RuntimeException("Fornecedor não encontrado com ID: "+id));

    }

    public void deletarId(Long id){
        produtoRepository.deleteById(id);
    }
}
