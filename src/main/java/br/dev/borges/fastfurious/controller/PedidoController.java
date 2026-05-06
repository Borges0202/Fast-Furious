package br.dev.borges.fastfurious.controller;

import br.dev.borges.fastfurious.model.Pedido;
import br.dev.borges.fastfurious.model.StatusPedido;
import br.dev.borges.fastfurious.service.PedidoService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    
    private PedidoService service;
    
    public PedidoController (PedidoService service){
        this.service = service;
    }
    
    @PostMapping
    public Pedido criar(@RequestBody Pedido pedido)
    {
        return service.criar(pedido);
    }
    
    @GetMapping("/status/{status}")
    public List<Pedido> buscarPorStatus(@PathVariable StatusPedido status){
        return service.buscarPorStatus(status);
    }
    
    @PutMapping("/{id}/status")
    public Pedido atualizarStatus(@PathVariable Long id, @RequestBody StatusPedido status){
        return service.atualizarStatus(id, status);
    }
}
