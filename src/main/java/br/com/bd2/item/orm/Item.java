package br.com.bd2.item.orm;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import br.com.bd2.produto.orm.Produto;
import br.com.bd2.venda.orm.Venda;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "item")
public class Item extends PanacheEntityBase {
    
    /**
     * id
     */
    @Id
    @GeneratedValue(generator = "ulid")
    @Column(name = "id_item", nullable = false)
    @GenericGenerator(name = "ulid", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID idItem;

    /**
     * produto
     */
    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
    @ManyToOne()
    private Produto produto;

    /**
     * venda
     */
    @JoinColumn(name = "id_venda", referencedColumnName = "id_venda")
    @ManyToOne()
    private Venda venda;

    /**
     * quantidade
     */
    @Column(name = "nr_quantidade")
    private Integer nrQuantidade;

    /**
     * valor parcial
     */
    @Column(name = "nr_valorparcial")
    private Double nrValorParcial;

    public UUID getIdItem() {
        return idItem;
    }

    public void setIdItem(UUID idItem) {
        this.idItem = idItem;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
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
