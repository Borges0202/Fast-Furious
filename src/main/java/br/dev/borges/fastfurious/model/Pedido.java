package br.dev.borges.fastfurious.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Pedido {
    
    
    @OneToMany
    @JoinColumn(name = "pedido_id")
    private List<Produto> produtos;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private StatusPedido status;

    private Double total;
    
    public Pedido(){
        this.status = StatusPedido.ABERTO;
    }

    public Long getId() {
        return id;
    }

    public StatusPedido getStatus(){
        return status;
    }

    public void setStatus(StatusPedido status){
    this.status = status;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
    
    
}
