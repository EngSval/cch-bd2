package br.com.bd2.fornecedor.converter;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.bd2.fornecedor.dto.FornecedorDto;
import br.com.bd2.fornecedor.orm.Fornecedor;
import br.com.bd2.produto.converter.ProdutoConverter;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@RequestScoped
public class FornecedorConverter {

    @Inject
    ProdutoConverter produtoConverter;
    
    public Fornecedor dtoToOrm(FornecedorDto dto, Fornecedor orm) {

        if(dto.getIdFornecedor() != null) {
            orm.setIdFornecedor(UUID.fromString(dto.getIdFornecedor()));
        }
        orm.setDsFornecedor(dto.getDsFornecedor());

        return orm;
    }

    public Fornecedor dtoToOrm(FornecedorDto dto) {
        return dtoToOrm(dto, new Fornecedor());
    }

    public FornecedorDto ormToDto(Fornecedor orm, FornecedorDto dto) {
        dto.setIdFornecedor(String.valueOf(orm.getIdFornecedor()));
        dto.setDsFornecedor(orm.getDsFornecedor());

        //dto.setProdutoList(produtoConverter.ormListToDtoList(orm.getProdutoList()));
        return dto;
    }

    public FornecedorDto ormToDto(Fornecedor orm) {
        return ormToDto(orm, new FornecedorDto());
    }

    public List<Fornecedor> dtoListToOrmList(List<FornecedorDto> dtoList) {
        if (dtoList == null) return null;
        return dtoList.stream().map(this::dtoToOrm).collect(Collectors.toList());
    }

    public List<FornecedorDto> ormListToDtoList(List<Fornecedor> ormList) {
        if (ormList == null) return null;
        return ormList.stream().map(this::ormToDto).collect(Collectors.toList());
    }

}
