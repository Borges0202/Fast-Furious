package br.dev.borges.service;

import br.dev.borges.fastfurious.model.Produto;
import br.dev.borges.fastfurious.repository.ProdutoRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;
    
    //injeção de dependencia
   
    public ProdutoService(ProdutoRepository repository){
        this.repository = repository;
    }
    
    //metodo de listar produtos
    public List<Produto> listarProdutos(){
        return repository.findAll();
    }
}
