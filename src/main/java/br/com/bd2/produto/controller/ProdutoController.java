package br.com.bd2.produto.controller;

import java.util.List;
import java.util.UUID;

import br.com.bd2.fornecedor.orm.Fornecedor;
import br.com.bd2.produto.converter.ProdutoConverter;
import br.com.bd2.produto.dto.ProdutoDto;
import br.com.bd2.produto.orm.Produto;
import br.com.bd2.produto.repository.ProdutoRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@RequestScoped
public class ProdutoController {
    @Inject
    ProdutoConverter produtoConverter;

    @Inject
    ProdutoRepository produtoRepository;

    @Transactional
    public ProdutoDto create(ProdutoDto produtoDto) {
        Produto produto = produtoConverter.dtoToOrm(produtoDto);

        Fornecedor fornecedor = Fornecedor.findById(UUID.fromString(produtoDto.getFornecedor().getIdFornecedor()));
        produto.setFornecedor(fornecedor);

        produtoRepository.persist(produto);
        return produtoConverter.ormToDto(produto, produtoDto);
    }

    @Transactional
    public ProdutoDto create(ProdutoDto produtoDto, Fornecedor fornecedor) {
        Produto produto = produtoConverter.dtoToOrm(produtoDto);

        produto.setFornecedor(fornecedor);

        produtoRepository.persist(produto);
        return produtoConverter.ormToDto(produto, produtoDto);
    }

    public ProdutoDto retrieve(UUID uuid) {
        return produtoConverter.ormToDto(produtoRepository.findById(uuid));
    }

    public List<ProdutoDto> retrieveAll() {
        List<Produto> produtoList = produtoRepository.listAll();
        return produtoConverter.ormListToDtoList(produtoList);
    }

    public List<ProdutoDto> findProdutoByFornecedor(String idFornecedor) {
        List<Produto> produtoList = produtoRepository.find("fornecedor.idFornecedor", UUID.fromString(idFornecedor)).list();

        return produtoConverter.ormListToDtoList(produtoList);
    }

    @Transactional
    public ProdutoDto update(ProdutoDto produtoDto) {
        Produto produto = produtoRepository.findById(UUID.fromString(produtoDto.getIdProduto()));

        Fornecedor fornecedor = Fornecedor.findById(UUID.fromString(produtoDto.getFornecedor().getIdFornecedor()));
        produto.setFornecedor(fornecedor);

        produtoConverter.dtoToOrm(produtoDto, produto);
        produtoRepository.persist(produto);
        return produtoDto;
    }

    @Transactional
    public boolean delete(UUID uuid) {
        try {
            Produto produto = produtoRepository.findById(uuid);
            produtoRepository.delete(produto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
