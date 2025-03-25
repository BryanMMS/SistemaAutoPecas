package org.example.entities;

import javax.persistence.*;

@Entity
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FORNECEDOR")
    private long idFornecedor;

    @Column(length = 50,name = "RAZAO_SOCIAL")
    private String razaoSocial;


    @Column(length = 100, name = "NOME_FANTASIA")
    private String nomeFantasia;

    @Column(name = "CNPJ")
    private int cnpj;

    @Column(length = 35, name = "STATUS_FORNECEDOR")
    private String status_Fornecedor;

    public Fornecedor() {
    }

    public long getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(long idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public String getStatus_Fornecedor() {
        return status_Fornecedor;
    }

    public void setStatus_Fornecedor(String status_Fornecedor) {
        this.status_Fornecedor = status_Fornecedor;
    }
}
