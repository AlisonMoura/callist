package com.redick.persistencia.entidade;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by alisonmoura on 17/07/15.
 *
 * Classe modelo para representar um Aluno
 *
 */
@Entity
public class Aluno{

    //Construtor padrão para o JPA
    public Aluno() {
    }

    @SequenceGenerator(name = "seq_aluno", sequenceName = "seq_aluno", initialValue = 1)
    @GeneratedValue(generator = "seq_aluno" ,strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    private String nome;
    private Integer idade;
    private String rg;
    private String cpf;
    @Embedded
    private Endereco endereco = new Endereco();

    /* Getters e Setters */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    /**
     * Método que deixa todos os atributos da instancia vazios e não nulos
     */
    public void reset(){
        this.nome = "";
        this.cpf = "";
        this.rg = "";
    }

}
