package br.com.bd2.funcionario.orm;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario extends PanacheEntityBase {

    /**
     * id
     */
    @Id
    @GeneratedValue(generator = "ulid")
    @Column(name = "id_funcionario", nullable = false)
    @GenericGenerator(name = "ulid", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID idFuncionario;

    /* @OneToMany(mappedBy = "fornecedor", fetch = FetchType.LAZY)
	private List<Venda> vendaList = new ArrayList<>(); */

    /**
     * Nome
     */
    @Column(name = "nm_funcionario")
    private String nmFuncionario;

    /**
     * Cpf
     */
    @Column(name = "nr_documento")
    private String nrDocumento;

    /**
     * Senha
     */
    @Column(name = "ds_senha")
    private String dsSenha;

    /**
     * Função
     */
    @Column(name = "ds_funcao")
    private String dsFuncao;

    public UUID getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(UUID idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNmFuncionario() {
        return nmFuncionario;
    }

    public void setNmFuncionario(String nmFuncionario) {
        this.nmFuncionario = nmFuncionario;
    }

    public String getNrDocumento() {
        return nrDocumento;
    }

    public void setNrDocumento(String nrDocumento) {
        this.nrDocumento = nrDocumento;
    }

    public String getDsSenha() {
        return dsSenha;
    }

    public void setDsSenha(String dsSenha) {
        this.dsSenha = dsSenha;
    }

    public String getDsFuncao() {
        return dsFuncao;
    }

    public void setDsFuncao(String dsFuncao) {
        this.dsFuncao = dsFuncao;
    }

    
}
