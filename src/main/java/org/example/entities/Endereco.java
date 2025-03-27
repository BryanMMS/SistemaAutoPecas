package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Endereco implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ENDERECO")
    private long idEndereco;

    @Column(length = 255, name = "RUA", nullable = false)
    private String rua;

    @Column(length = 20, name = "NUMERO", nullable = false)
    private String numero;

    @Column(length = 100, name = "BAIRRO", nullable = false)
    private String bairro;

    @Column(length = 100, name = "CIDADE", nullable = false)
    private String cidade;

    @Column(length = 50, name = "ESTADO", nullable = false)
    private String estado;

    @Column(length = 10, name = "CEP", nullable = false)
    private String cep;

    @Column(length = 50, name = "TIPO_ENDERECO", nullable = false)
    private String tipoEndereco;  // Exemplo: "Residencial", "Comercial", "Entrega", etc.

    public Endereco() {
    }

    public Endereco(long idEndereco, String rua, String numero, String bairro, String cidade, String estado, String cep, String tipoEndereco) {
        this.idEndereco = idEndereco;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.tipoEndereco = tipoEndereco;
    }

    public long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(String tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }
}
