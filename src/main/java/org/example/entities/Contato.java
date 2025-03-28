package org.example.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Contato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONTATO")
    private long idContato;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "CON_FOR_ID")
    private Fornecedor conFornecedor;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "CON_CLI_ID")
    private Fornecedor conCliente;

    @Column(length = 15, name = "TELEFONE", nullable = false)
    private String telefoneContato;

    @Column(length = 100, name = "NOME", nullable = false)
    private String nomeContato;

    @Column(length = 100, name = "EMAIL", nullable = false)
    private String emailContato;

    public Contato() {
    }

    public Contato(long idContato, Fornecedor conFornecedor, Fornecedor conCliente, String telefoneContato, String nomeContato, String emailContato) {
        this.idContato = idContato;
        this.conFornecedor = conFornecedor;
        this.conCliente = conCliente;
        this.telefoneContato = telefoneContato;
        this.nomeContato = nomeContato;
        this.emailContato = emailContato;
    }

    public long getIdContato() {
        return idContato;
    }

    public void setIdContato(long idContato) {
        this.idContato = idContato;
    }

    public Fornecedor getConFornecedor() {
        return conFornecedor;
    }

    public void setConFornecedor(Fornecedor conFornecedor) {
        this.conFornecedor = conFornecedor;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getEmailContato() {
        return emailContato;
    }

    public void setEmailContato(String emailContato) {
        this.emailContato = emailContato;
    }

    public Fornecedor getConCliente() {
        return conCliente;
    }

    public void setConCliente(Fornecedor conCliente) {
        this.conCliente = conCliente;
    }
}
