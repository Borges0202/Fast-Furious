package br.dev.borges.fastfurious.service;

import br.dev.borges.fastfurious.model.Pedido;
import br.dev.borges.fastfurious.model.StatusPedido;
import br.dev.borges.fastfurious.repository.PedidoRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    
    private final PedidoRepository repository;
    
        public PedidoService(PedidoRepository repository){
            this.repository = repository;
        }
    
        public Pedido criar(Pedido pedido){
        
            return repository.save(pedido);
        
        }
        
        public List<Pedido> buscarPorStatus(StatusPedido status){
            return repository.findByStatus(status);
        }
}
