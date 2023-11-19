package br.com.bd2.item.repository;

import java.util.UUID;

import br.com.bd2.item.orm.Item;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class ItemRepository implements PanacheRepository<Item> {
    public Item findById(UUID uuid) {
        return Item.findById(uuid);
    }
}
