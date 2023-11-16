package br.com.bd2.produto.converter;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.bd2.fornecedor.converter.FornecedorConverter;
import br.com.bd2.produto.dto.ProdutoDto;
import br.com.bd2.produto.orm.Produto;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@RequestScoped
public class ProdutoConverter {
    
    @Inject
    FornecedorConverter fornecedorConverter;

    public Produto dtoToOrm(ProdutoDto dto, Produto orm) {

        if(dto.getIdProduto() != null) {
            orm.setIdProduto(UUID.fromString(dto.getIdProduto()));
        }
        orm.setDsProduto(dto.getDsProduto());
        orm.setNrValor(dto.getNrValor());
        orm.setNrQuantidade(dto.getNrQuantidade());

        return orm;
    }

    public Produto dtoToOrm(ProdutoDto dto) {
        return dtoToOrm(dto, new Produto());
    }

    public ProdutoDto ormToDto(Produto orm, ProdutoDto dto) {
        dto.setIdProduto(String.valueOf(orm.getIdProduto()));
        dto.setNrValor(orm.getNrValor());
        dto.setDsProduto(orm.getDsProduto());
        dto.setNrQuantidade(orm.getNrQuantidade());
        dto.setFornecedor(fornecedorConverter.ormToDto(orm.getFornecedor()));
        return dto;
    }

    public ProdutoDto ormToDto(Produto orm) {
        return ormToDto(orm, new ProdutoDto());
    }

    public List<Produto> dtoListToOrmList(List<ProdutoDto> dtoList) {
        if (dtoList == null) return null;
        return dtoList.stream().map(this::dtoToOrm).collect(Collectors.toList());
    }

    public List<ProdutoDto> ormListToDtoList(List<Produto> ormList) {
        if (ormList == null) return null;
        return ormList.stream().map(this::ormToDto).collect(Collectors.toList());
    }

}
