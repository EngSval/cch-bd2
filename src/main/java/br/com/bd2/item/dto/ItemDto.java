package br.com.bd2.item.dto;

import br.com.bd2.produto.dto.ProdutoDto;
import br.com.bd2.venda.dto.VendaDto;

public class ItemDto {
    
    /**
     * id
     */
    private String idItem;

    /**
     * produto
     */
    private ProdutoDto produto;

    /**
     * venda
     */
    private VendaDto venda;

    /**
     * quantidade
     */
    private Integer nrQuantidade;

    /**
     * valor parcial
     */
    private Double nrValorParcial;

    public String getIdItem() {
        return idItem;
    }

    public void setIdItem(String idItem) {
        this.idItem = idItem;
    }

    public ProdutoDto getProduto() {
        return produto;
    }

    public void setProduto(ProdutoDto produto) {
        this.produto = produto;
    }

    public VendaDto getVenda() {
        return venda;
    }

    public void setVenda(VendaDto venda) {
        this.venda = venda;
    }

    public Integer getNrQuantidade() {
        return nrQuantidade;
    }

    public void setNrQuantidade(Integer nrQuantidade) {
        this.nrQuantidade = nrQuantidade;
    }

    public Double getNrValorParcial() {
        return nrValorParcial;
    }

    public void setNrValorParcial(Double nrValorParcial) {
        this.nrValorParcial = nrValorParcial;
    }

}
