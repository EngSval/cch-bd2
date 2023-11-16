package br.com.bd2.funcionario.converter;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.bd2.funcionario.dto.FuncionarioDto;
import br.com.bd2.funcionario.orm.Funcionario;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class FuncionarioConverter {
    
    public Funcionario dtoToOrm(FuncionarioDto dto, Funcionario orm) {

        if(dto.getIdFuncionario() != null) {
            orm.setIdFuncionario(UUID.fromString(dto.getIdFuncionario()));
        }
        orm.setNmFuncionario(dto.getNmFuncionario());
        orm.setNrDocumento(dto.getNrDocumento());
        orm.setDsSenha(dto.getDsSenha());
        orm.setDsFuncao(dto.getDsFuncao());

        return orm;
    }

    public Funcionario dtoToOrm(FuncionarioDto dto) {
        return dtoToOrm(dto, new Funcionario());
    }

    public FuncionarioDto ormToDto(Funcionario orm, FuncionarioDto dto) {
        dto.setIdFuncionario(String.valueOf(orm.getIdFuncionario()));
        dto.setNmFuncionario(orm.getNmFuncionario());
        dto.setNrDocumento(orm.getNrDocumento());
        dto.setDsSenha(orm.getDsSenha());
        dto.setDsFuncao(orm.getDsFuncao());
        return dto;
    }

    public FuncionarioDto ormToDto(Funcionario orm) {
        return ormToDto(orm, new FuncionarioDto());
    }

    public List<Funcionario> dtoListToOrmList(List<FuncionarioDto> dtoList) {
        if (dtoList == null) return null;
        return dtoList.stream().map(this::dtoToOrm).collect(Collectors.toList());
    }

    public List<FuncionarioDto> ormListToDtoList(List<Funcionario> ormList) {
        if (ormList == null) return null;
        return ormList.stream().map(this::ormToDto).collect(Collectors.toList());
    }

}
