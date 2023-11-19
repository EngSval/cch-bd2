package br.com.bd2.venda.orm;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import br.com.bd2.funcionario.orm.Funcionario;
import br.com.bd2.item.orm.Item;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "venda")
public class Venda extends PanacheEntityBase {
    
    /**
     * id
     */
    @Id
    @GeneratedValue(generator = "ulid")
    @Column(name = "id_venda", nullable = false)
    @GenericGenerator(name = "ulid", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID idVenda;

    /**
     * funcionario
     */
    @JoinColumn(name = "id_funcionario", referencedColumnName = "id_funcionario")
    @ManyToOne()
    private Funcionario funcionario;

    @OneToMany(mappedBy = "venda", fetch = FetchType.LAZY)
	private List<Item> itemList = new ArrayList<>();

    /**
     * data
     */
    @Column(name = "dt_venda")
    private LocalDateTime dtVenda;

    /**
     * valor total
     */
    @Column(name = "nr_valorTotal")
    private Double nrValorTotal;

    public UUID getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(UUID idVenda) {
        this.idVenda = idVenda;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public LocalDateTime getDtVenda() {
        return dtVenda;
    }

    public void setDtVenda(LocalDateTime dtVenda) {
        this.dtVenda = dtVenda;
    }

    public Double getNrValorTotal() {
        return nrValorTotal;
    }

    public void setNrValorTotal(Double nrValorTotal) {
        this.nrValorTotal = nrValorTotal;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

}
