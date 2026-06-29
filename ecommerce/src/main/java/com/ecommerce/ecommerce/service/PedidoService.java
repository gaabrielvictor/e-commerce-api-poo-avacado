package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.Pedido;
import com.ecommerce.ecommerce.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public List<Pedido> listarTodos(){
        return repository.findAll();
    }

    public Optional<Pedido> buscarPorId(String id) {
        return repository.findById(id);
    }

    public Pedido salvar(Pedido pedido){
        return repository.save(pedido);
    }

    public void deletar(String id){
        repository.deleteById(id);
    }

    public Pedido atualizar(String id, Pedido novo) {
        return repository.findById(id).map(p -> {
            p.setStatus(novo.getStatus());
            p.setValorTotal(novo.getValorTotal());
            p.setItens(novo.getItens());
            return repository.save(p);
        }).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

}
