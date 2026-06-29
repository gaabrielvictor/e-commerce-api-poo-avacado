package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.Categoria;
import com.ecommerce.ecommerce.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> listarTodos() {
        return repository.findAll();
    }

    public Optional<Categoria> buscarPorId(String id) {
        return repository.findById(id);
    }

    public Categoria salvar(Categoria categoria) {
        return repository.save(categoria);
    }

    public void deletar(String id) {
        repository.deleteById(id);
    }

    public Categoria atualizar(String id, Categoria nova) {
        return repository.findById(id).map(c -> {
            c.setNome(nova.getNome());
            c.setDescricao(nova.getDescricao());
            return repository.save(c);
        }).orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }
}