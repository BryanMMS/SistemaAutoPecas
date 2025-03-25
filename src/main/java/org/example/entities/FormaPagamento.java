package org.example.entities;

import javax.persistence.*;

@Entity
public class FormaPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FORMAPAGAMENTO")
    private long idFormapagamento;

    @Column(length = 100, name = "DESCRICAO", nullable = false)
    private String descricao;

    @Column(length = 50, name = "TIPO", nullable = false)
    private String tipo;

    @Column(length = 35, name = "STATUS", nullable = false)
    private String statuspagamento;


    public FormaPagamento() {
    }

    public FormaPagamento(long idFormapagamento, String descricao, String tipo, String statuspagamento) {
        this.idFormapagamento = idFormapagamento;
        this.descricao = descricao;
        this.tipo = tipo;
        this.statuspagamento = statuspagamento;
    }

    public long getIdFormapagamento() {
        return idFormapagamento;
    }

    public void setIdFormapagamento(long idFormapagamento) {
        this.idFormapagamento = idFormapagamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatuspagamento() {
        return statuspagamento;
    }

    public void setStatuspagamento(String statuspagamento) {
        this.statuspagamento = statuspagamento;
    }
}
