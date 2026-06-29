package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.Produto;
import com.ecommerce.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public Optional<Produto> buscarPorId(String id) {
        return repository.findById(id);
    }

    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    public void deletar(String id) {
        repository.deleteById(id);
    }

    public Produto atualizar(String id, Produto novo) {
        return repository.findById(id).map(p -> {
            p.setNome(novo.getNome());
            p.setDescricao(novo.getDescricao());
            p.setPreco(novo.getPreco());
            p.setEstoque(novo.getEstoque());
            p.setCategoria(novo.getCategoria());
            return repository.save(p);
        }).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }
}