package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Contato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONTATO")
    private long idContato;

    @Column(length = 15, name = "TELEFONE", nullable = false)
    private String telefoneContato;

    @Column(length = 100, name = "NOME", nullable = false)
    private String nomeContato;

    @Column(length = 100, name = "EMAIL", nullable = false)
    private String emailContato;

    public Contato() {
    }

    public Contato(long idContato, String telefoneContato, String nomeContato, String emailContato) {
        this.idContato = idContato;
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
}
