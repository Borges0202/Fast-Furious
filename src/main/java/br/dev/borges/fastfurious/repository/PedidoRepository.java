package br.dev.borges.fastfurious.repository;

import br.dev.borges.fastfurious.model.Pedido;
import br.dev.borges.fastfurious.model.StatusPedido;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByStatus(StatusPedido status); 
}
