package br.com.bd2.produto.dto;

import br.com.bd2.enumeration.SituacaoRegistroEnum;
import br.com.bd2.fornecedor.dto.FornecedorDto;

public class ProdutoDto {

    /**
     * id
     */
    private String idProduto;

    /**
     * fornecedor
     */
    private FornecedorDto fornecedor;

    /**
     * Descrição
     */
    private String dsProduto;

    /**
     * Valor
     */
    private Double nrValor;

    /**
     * Quantidade
     */
    private Integer nrQuantidade;

    /**
     * Situação do registro
     */
    private SituacaoRegistroEnum stRegistro;

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    public FornecedorDto getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(FornecedorDto fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getDsProduto() {
        return dsProduto;
    }

    public void setDsProduto(String dsProduto) {
        this.dsProduto = dsProduto;
    }

    public Double getNrValor() {
        return nrValor;
    }

    public void setNrValor(Double nrValor) {
        this.nrValor = nrValor;
    }

    public Integer getNrQuantidade() {
        return nrQuantidade;
    }

    public void setNrQuantidade(Integer nrQuantidade) {
        this.nrQuantidade = nrQuantidade;
    }

    public SituacaoRegistroEnum getStRegistro() {
        return stRegistro;
    }

    public void setStRegistro(SituacaoRegistroEnum stRegistro) {
        this.stRegistro = stRegistro;
    }

    
}
