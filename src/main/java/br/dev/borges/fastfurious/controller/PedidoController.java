package br.dev.borges.fastfurious.controller;

import br.dev.borges.fastfurious.model.Pedido;
import br.dev.borges.fastfurious.service.PedidoService;
import org.springframework.web.bind.annotation.PostMapping;
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
}
