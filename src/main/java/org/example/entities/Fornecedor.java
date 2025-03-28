package org.example.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FORNECEDOR")
    private long idFornecedor;

    @OneToMany(mappedBy = "conFornecedor", cascade = CascadeType.ALL)
    private List<Contato> contatos = new ArrayList<>();


    @Column(length = 100,name = "NOME")
    private String nome;
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

    public Fornecedor(long idFornecedor, List<Contato> contatos, String nome, String razaoSocial, String nomeFantasia, int cnpj, String status_Fornecedor, long idContato, String telefoneContato, String nomeContato, String emailContato) {
        this.idFornecedor = idFornecedor;
        this.contatos = contatos;
        this.nome = nome;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.status_Fornecedor = status_Fornecedor;
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

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
