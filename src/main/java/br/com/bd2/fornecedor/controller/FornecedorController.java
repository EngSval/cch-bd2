package br.com.bd2.fornecedor.controller;

import java.util.List;
import java.util.UUID;

import br.com.bd2.fornecedor.converter.FornecedorConverter;
import br.com.bd2.fornecedor.dto.FornecedorDto;
import br.com.bd2.fornecedor.orm.Fornecedor;
import br.com.bd2.fornecedor.repository.FornecedorRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@RequestScoped
public class FornecedorController {

    @Inject
    FornecedorConverter fornecedorConverter;

    @Inject
    FornecedorRepository fornecedorRepository;

    @Transactional
    public FornecedorDto create(FornecedorDto fornecedorDto) {
        Fornecedor fornecedor = fornecedorConverter.dtoToOrm(fornecedorDto);
        fornecedorRepository.persist(fornecedor);
        return fornecedorConverter.ormToDto(fornecedor, fornecedorDto);
    }

    public FornecedorDto retrieve(UUID uuid) {
        return fornecedorConverter.ormToDto(fornecedorRepository.findById(uuid));
    }

    public List<FornecedorDto> retrieveAll() {
        List<Fornecedor> fornecedorList = fornecedorRepository.listAll();
        return fornecedorConverter.ormListToDtoList(fornecedorList);
    }

    @Transactional
    public FornecedorDto update(FornecedorDto fornecedorDto) {
        Fornecedor fornecedor = fornecedorRepository.findById(UUID.fromString(fornecedorDto.getIdFornecedor()));
        fornecedorConverter.dtoToOrm(fornecedorDto, fornecedor);
        fornecedorRepository.persist(fornecedor);
        return fornecedorDto;
    }

    @Transactional
    public boolean delete(UUID uuid) {
        try {
            Fornecedor fornecedor = fornecedorRepository.findById(uuid);
            fornecedorRepository.delete(fornecedor);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
