package br.com.bd2.produto.orm;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import br.com.bd2.fornecedor.orm.Fornecedor;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto extends PanacheEntityBase {

    /**
     * id
     */
    @Id
    @GeneratedValue(generator = "ulid")
    @Column(name = "id_produto", nullable = false)
    @GenericGenerator(name = "ulid", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID idProduto;

    /**
     * fornecedor
     */
    @JoinColumn(name = "id_fornecedor", referencedColumnName = "id_fornecedor")
    @ManyToOne()
    private Fornecedor fornecedor;

    /**
     * Descrição
     */
    @Column(name = "ds_produto")
    private String dsProduto;

    /**
     * Valor
     */
    @Column(name = "nr_valor")
    private Double nrValor;

    /**
     * Quantidade
     */
    @Column(name = "nr_quantidade")
    private Integer nrQuantidade;

    public UUID getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(UUID idProduto) {
        this.idProduto = idProduto;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
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

    
}
