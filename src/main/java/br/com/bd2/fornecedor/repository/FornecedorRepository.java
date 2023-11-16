package br.com.bd2.fornecedor.repository;

import java.util.UUID;

import br.com.bd2.fornecedor.orm.Fornecedor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class FornecedorRepository implements PanacheRepository<Fornecedor> {
    public Fornecedor findById(UUID uuid) {
        return Fornecedor.findById(uuid);
    }
}
