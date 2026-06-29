package com.ecommerce.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedido {

    private Integer quantidade;
    private Double precoUnitario;

    @DBRef
    private Produto produto;
}
