package com.redick.persistencia.entidade;

import javax.persistence.Embeddable;

/**
 * Created by alisonmoura on 17/07/15.
 *
 * Classe modelo para guardar informações sobre o endereço dos alunos
 *
 */

@Embeddable
public class Endereco {

    private String cep;
    private String estado;
    private String cidade;
    private String bairro;
    private String tipoLogradouro;
    private String logradouro;
    private Integer numero;

    /* Getters e Setters */

    public String getCep() {
        return cep;
    }

    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

}
