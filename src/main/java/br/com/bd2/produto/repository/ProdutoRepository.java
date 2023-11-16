package br.com.bd2.produto.repository;

import java.util.UUID;

import br.com.bd2.produto.orm.Produto;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class ProdutoRepository implements PanacheRepository<Produto> {
    public Produto findById(UUID uuid) {
        return Produto.findById(uuid);
    }
}
