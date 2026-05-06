package br.dev.borges.fastfurious.service;

import br.dev.borges.fastfurious.model.Pedido;
import br.dev.borges.fastfurious.model.Produto;
import br.dev.borges.fastfurious.model.StatusPedido;
import br.dev.borges.fastfurious.repository.PedidoRepository;
import br.dev.borges.fastfurious.repository.ProdutoRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    
    private final PedidoRepository repository;
    
    private final ProdutoRepository produtoRepository;
    
        public PedidoService(PedidoRepository repository, ProdutoRepository produtoRepository){
            this.repository = repository;
            this.produtoRepository = produtoRepository;
        }
    
        public Pedido criar(Pedido pedido){
            
            List<Long> ids = pedido.getProdutos()
                    .stream()
                    .map(p -> p.getId())
                    .toList();
            
            List<Produto> produtos = produtoRepository.findAllById(ids);
            
            pedido.setProdutos(produtos);
            
            double total = produtos.stream()
                .mapToDouble(p -> p.getPreco())
                .sum();
            
            pedido.setTotal(total);
            
            return repository.save(pedido);
        
        }
        
        public List<Pedido> buscarPorStatus(StatusPedido status){
            return repository.findByStatus(status);
        }
        
        public Pedido atualizarStatus(Long id, StatusPedido status){
            Pedido pedido = repository.findById(id).orElse(null);
            
            if (pedido ==null){
                return null;
            }
            
            pedido.setStatus(status);
            
            return repository.save(pedido);
        }
        
}
