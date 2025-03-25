package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE")
    private long idcliente;

    @Column(length = 55, name = "NOME_CLIENTE", nullable = false)
    private String nome;

    @Column(name = "CPF", nullable = false)
    private int cpf;

    @Column(name = "DATA_NASCIMENTO", nullable = false)
    private LocalDate dataNascimento;

    @Column(length = 35, name = "STATUS", nullable = false)
    private String statuscliente;

    public Cliente(){

    }

    public Cliente(long idcliente, String nome, int cpf, LocalDate dataNascimento, String statuscliente) {
        this.idcliente = idcliente;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.statuscliente = statuscliente;
    }

    public long getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(long idcliente) {
        this.idcliente = idcliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getStatuscliente() {
        return statuscliente;
    }

    public void setStatuscliente(String statuscliente) {
        this.statuscliente = statuscliente;
    }
}
