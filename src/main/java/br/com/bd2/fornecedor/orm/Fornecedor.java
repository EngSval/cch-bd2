package br.com.bd2.fornecedor.orm;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import br.com.bd2.produto.orm.Produto;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "fornecedor")
public class Fornecedor extends PanacheEntityBase {

    /**
     * id
     */
    @Id
    @GeneratedValue(generator = "ulid")
    @Column(name = "id_fornecedor", nullable = false)
    @GenericGenerator(name = "ulid", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID idFornecedor;

    @OneToMany(mappedBy = "fornecedor", fetch = FetchType.LAZY)
	private List<Produto> produtoList = new ArrayList<>();

    /**
     * Descrição
     */
    @Column(name = "ds_fornecedor", nullable = false)
    private String dsFornecedor;

    public UUID getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(UUID idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getDsFornecedor() {
        return dsFornecedor;
    }

    public void setDsFornecedor(String dsFornecedor) {
        this.dsFornecedor = dsFornecedor;
    }

    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }
  
}
