package br.com.bd2.venda.repository;

import java.util.UUID;

import br.com.bd2.venda.orm.Venda;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class VendaRepository implements PanacheRepository<Venda> {
    public Venda findById(UUID uuid) {
        return Venda.findById(uuid);
    }
}
