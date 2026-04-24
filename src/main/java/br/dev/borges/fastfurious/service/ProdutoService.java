package br.dev.borges.fastfurious.service;

import br.dev.borges.fastfurious.model.Produto;
import java.util.List;
import org.springframework.stereotype.Service;
import br.dev.borges.fastfurious.repository.ProdutoRepository;

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
    
    public Produto criar(Produto produto){
        
        return repository.save(produto);
        
    }
    
    public Produto buscar(Long id){
        return repository.findById(id).orElse(null);
    }
    
    public void deletar(Long id){
        repository.deleteById(id);
    }
    
    public Produto atualizar(Long id, Produto produto){
       Produto produtoExistente = repository.findById(id).orElse(null);
       produtoExistente.setNome(produto.getNome());
       produtoExistente.setPreco(produto.getPreco());
       produtoExistente.setCategoria(produto.getCategoria());
       return repository.save(produtoExistente);
    }
}
