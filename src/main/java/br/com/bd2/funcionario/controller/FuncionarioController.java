package br.com.bd2.funcionario.controller;

import java.util.List;
import java.util.UUID;

import br.com.bd2.enumeration.SituacaoRegistroEnum;
import br.com.bd2.fornecedor.converter.FornecedorConverter;
import br.com.bd2.fornecedor.dto.FornecedorDto;
import br.com.bd2.fornecedor.orm.Fornecedor;
import br.com.bd2.fornecedor.repository.FornecedorRepository;
import br.com.bd2.funcionario.converter.FuncionarioConverter;
import br.com.bd2.funcionario.dto.FuncionarioDto;
import br.com.bd2.funcionario.orm.Funcionario;
import br.com.bd2.funcionario.repository.FuncionarioRepository;
import br.com.bd2.produto.controller.ProdutoController;
import br.com.bd2.produto.converter.ProdutoConverter;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@RequestScoped
public class FuncionarioController {
    
    @Inject
    FuncionarioConverter funcionarioConverter;

    @Inject
    FuncionarioRepository funcionarioRepository;

    /* @Inject
    VendaController vendaController;

    @Inject
    VendaConverter vendaConverter; */

    @Transactional
    public FuncionarioDto create(FuncionarioDto funcionarioDto) {
        Funcionario funcionario = funcionarioConverter.dtoToOrm(funcionarioDto);
        funcionarioRepository.persist(funcionario);
        /* funcionarioDto.getVendaList().forEach(venda -> vendaController.create(venda, funcionario)); */
        return funcionarioConverter.ormToDto(funcionario, funcionarioDto);
    }

    public FuncionarioDto retrieve(UUID uuid) {

        Funcionario funcionario = funcionarioRepository.findById(uuid);
        FuncionarioDto funcionarioDto = funcionarioConverter.ormToDto(funcionario);
        /* funcionario.setVendaList(vendaConverter.ormListToDtoList(funcionario.getVendaList())); */

        return funcionarioDto;
    }

    public List<FuncionarioDto> retrieveAll() {
        List<Funcionario> funcionarioList = funcionarioRepository.listAll();
        List<FuncionarioDto> funcionarioDtoList = funcionarioConverter.ormListToDtoList(funcionarioList);
        /* for (FuncionarioDto funcionarioDto : funcionarioDtoList) {
            funcionarioDto.setVendaList(
                vendaController.findVendaByFuncionario(funcionarioDto.getIdVenda()));
        } */
        return funcionarioDtoList;
    }

    @Transactional
    public FuncionarioDto update(FuncionarioDto funcionarioDto) {
        Funcionario funcionario = funcionarioRepository.findById(UUID.fromString(funcionarioDto.getIdFuncionario()));

        /* funcionarioDto.getVendaList().forEach(venda -> {
            if (venda.getStRegistro() == SituacaoRegistroEnum.CREATE) {
                vendaController.create(venda, fornecedor);
            } else if (venda.getStRegistro() == SituacaoRegistroEnum.UPDATE) {
                vendaController.update(venda);
            } else if (venda.getStRegistro() == SituacaoRegistroEnum.DELETE) {
                vendaController.delete(UUID.fromString(venda.getIdVenda()));
            }
        }); */

        funcionarioConverter.dtoToOrm(funcionarioDto, funcionario);
        funcionarioRepository.persist(funcionario);
        return funcionarioDto;
    }

    @Transactional
    public boolean delete(UUID uuid) {
        try {
            Funcionario funcionario = funcionarioRepository.findById(uuid);
            /* funcionario.getVendaList().forEach(venda -> vendaController
                    .delete(venda.getIdVenda())); */
            funcionarioRepository.delete(funcionario);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
