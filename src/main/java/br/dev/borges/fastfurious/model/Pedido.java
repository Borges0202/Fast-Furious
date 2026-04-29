package br.dev.borges.fastfurious.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import br.dev.borges.fastfurious.model.StatusPedido;

@Entity
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private StatusPedido status;
    
    public Pedido(){
        this.status = StatusPedido.ABERTO;
    }

    public Long getId() {
        return id;
    }

    public StatusPedido getStatus(){
        return status;
    }

    
    
    
}
