package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.Cliente;
import com.ecommerce.ecommerce.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> listarTodos(){
        return repository.findAll();
    }

    public Optional<Cliente> buscarPorId(String id){
        return repository.findById(id);
    }

    public Cliente salvar(Cliente cliente){
        return repository.save(cliente);
    }

    public void deletar(String id){
        repository.deleteById(id);
    }

    public Cliente atualizar(String id, Cliente novo) {
        return repository.findById(id).map(c -> {
            c.setNome(novo.getNome());
            c.setEmail(novo.getEmail());
            c.setTelefone(novo.getTelefone());
            c.setCpf(novo.getCpf());
            return repository.save(c);
        }).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }
}
