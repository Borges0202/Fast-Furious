
package br.dev.borges.fastfurious.controller;

import br.dev.borges.fastfurious.model.Produto;
import br.dev.borges.fastfurious.service.ProdutoService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
      
    private ProdutoService service;
    
    public ProdutoController(ProdutoService service)
    {
        this.service = service;
    }
        
    @GetMapping
    public List<Produto> listar()
    {
        return service.listarProdutos();
    }
   
    @PostMapping
    public Produto criar(@RequestBody Produto produto)
    {
        return service.criar(produto);
    }
    
    @GetMapping("/{id}")
    public Produto buscar(@PathVariable Long id){
        return service.buscar(id);
    }
    
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
    
    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto produto){
        return service.atualizar(id, produto);
    }
}
