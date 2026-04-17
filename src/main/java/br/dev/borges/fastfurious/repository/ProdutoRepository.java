package br.dev.borges.fastfurious.repository;

import br.dev.borges.fastfurious.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository <Produto, Long> {

}