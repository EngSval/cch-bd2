package br.com.bd2.venda.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.bd2.funcionario.dto.FuncionarioDto;
import br.com.bd2.item.dto.ItemDto;

public class VendaDto {
    
    /**
     * id
     */
    private String idVenda;

    /**
     * funcionario
     */
    private FuncionarioDto funcionario;

    private List<ItemDto> itemList = new ArrayList<>();

    /**
     * data
     */
    private String dtVenda;

    /**
     * valor total
     */
    private Double nrValorTotal;

    public String getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(String idVenda) {
        this.idVenda = idVenda;
    }

    public FuncionarioDto getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioDto funcionario) {
        this.funcionario = funcionario;
    }

    public String getDtVenda() {
        return dtVenda;
    }

    public void setDtVenda(String dtVenda) {
        this.dtVenda = dtVenda;
    }

    public Double getNrValorTotal() {
        return nrValorTotal;
    }

    public void setNrValorTotal(Double nrValorTotal) {
        this.nrValorTotal = nrValorTotal;
    }

    public List<ItemDto> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemDto> itemList) {
        this.itemList = itemList;
    }

}
