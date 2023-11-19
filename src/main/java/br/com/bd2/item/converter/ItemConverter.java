package br.com.bd2.item.converter;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.bd2.item.dto.ItemDto;
import br.com.bd2.item.orm.Item;
import br.com.bd2.produto.converter.ProdutoConverter;
import br.com.bd2.venda.converter.VendaConverter;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@RequestScoped
public class ItemConverter {
    
    @Inject
    ProdutoConverter produtoConverter;

    @Inject
    VendaConverter vendaConverter;

    public Item dtoToOrm(ItemDto dto, Item orm) {

        if(dto.getIdItem() != null) {
            orm.setIdItem(UUID.fromString(dto.getIdItem()));
        }
        orm.setNrQuantidade(dto.getNrQuantidade());

        return orm;
    }

    public Item dtoToOrm(ItemDto dto) {
        return dtoToOrm(dto, new Item());
    }

    public ItemDto ormToDto(Item orm, ItemDto dto) {
        dto.setIdItem(String.valueOf(orm.getIdItem()));
        dto.setNrQuantidade(orm.getNrQuantidade());
        dto.setNrValorParcial(orm.getNrValorParcial());

        dto.setProduto(produtoConverter.ormToDto(orm.getProduto()));
        dto.setVenda(vendaConverter.ormToDto(orm.getVenda()));
        return dto;
    }

    public ItemDto ormToDto(Item orm) {
        return ormToDto(orm, new ItemDto());
    }

    public List<Item> dtoListToOrmList(List<ItemDto> dtoList) {
        if (dtoList == null) return null;
        return dtoList.stream().map(this::dtoToOrm).collect(Collectors.toList());
    }

    public List<ItemDto> ormListToDtoList(List<Item> ormList) {
        if (ormList == null) return null;
        return ormList.stream().map(this::ormToDto).collect(Collectors.toList());
    }

}
