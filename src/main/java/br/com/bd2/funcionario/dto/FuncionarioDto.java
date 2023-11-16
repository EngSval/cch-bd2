package br.com.bd2.funcionario.dto;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioDto {
    
    /**
     * id
     */
    private String idFuncionario;

   /*  private List<VendaDto> vendaList = new ArrayList<>(); */

    /**
     * Nome
     */
    private String nmFuncionario;

    /**
     * Cpf
     */
    private String nrDocumento;

    /**
     * Senha
     */
    private String dsSenha;

    /**
     * Função
     */
    private String dsFuncao;

    public String getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(String idFuncionario) {
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
