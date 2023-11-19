package br.com.bd2.venda.converter;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.bd2.funcionario.converter.FuncionarioConverter;
import br.com.bd2.venda.dto.VendaDto;
import br.com.bd2.venda.orm.Venda;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@RequestScoped
public class VendaConverter {
    
    @Inject
    FuncionarioConverter funcionarioConverter;

    public Venda dtoToOrm(VendaDto dto, Venda orm) {

        if(dto.getIdVenda() != null) {
            orm.setIdVenda(UUID.fromString(dto.getIdVenda()));
        }

        return orm;
    }

    public Venda dtoToOrm(VendaDto dto) {
        return dtoToOrm(dto, new Venda());
    }

    public VendaDto ormToDto(Venda orm, VendaDto dto) {
        dto.setIdVenda(String.valueOf(orm.getIdVenda()));
        dto.setDtVenda(String.valueOf(orm.getDtVenda()));
        dto.setNrValorTotal(orm.getNrValorTotal());
        dto.setFuncionario(funcionarioConverter.ormToDto(orm.getFuncionario()));
        return dto;
    }

    public VendaDto ormToDto(Venda orm) {
        return ormToDto(orm, new VendaDto());
    }

    public List<Venda> dtoListToOrmList(List<VendaDto> dtoList) {
        if (dtoList == null) return null;
        return dtoList.stream().map(this::dtoToOrm).collect(Collectors.toList());
    }

    public List<VendaDto> ormListToDtoList(List<Venda> ormList) {
        if (ormList == null) return null;
        return ormList.stream().map(this::ormToDto).collect(Collectors.toList());
    }


}
