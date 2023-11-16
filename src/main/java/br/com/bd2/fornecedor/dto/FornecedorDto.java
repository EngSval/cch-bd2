package br.com.bd2.fornecedor.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.bd2.produto.dto.ProdutoDto;

public class FornecedorDto {

    /**
     * id
     */
    private String idFornecedor;

	private List<ProdutoDto> produtoList = new ArrayList<>();

    /**
     * Descrição
     */
    private String dsFornecedor;

    public String getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(String idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getDsFornecedor() {
        return dsFornecedor;
    }

    public void setDsFornecedor(String dsFornecedor) {
        this.dsFornecedor = dsFornecedor;
    }

    public List<ProdutoDto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<ProdutoDto> produtoList) {
        this.produtoList = produtoList;
    }

    
}
