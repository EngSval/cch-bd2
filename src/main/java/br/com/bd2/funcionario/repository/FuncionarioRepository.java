package br.com.bd2.funcionario.repository;

import java.util.UUID;

import br.com.bd2.funcionario.orm.Funcionario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class FuncionarioRepository implements PanacheRepository<Funcionario> {
    public Funcionario findById(UUID uuid) {
        return Funcionario.findById(uuid);
    }
}
