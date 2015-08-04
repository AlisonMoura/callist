package com.redick.persistencia.entidade;

import javax.persistence.*;

/**
 * Created by alisonmoura on 17/07/15.
 *
 * Classe modelo para representar um Aluno
 *
 */
@Entity
public class Aluno {


    //Construtor padrão para o JPA
    public Aluno() {
    }

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    private String nome;
    private Integer idade;
    private String rg;
    private String cpf;
    @Embedded
    private Endereco endereco;

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

    /* HashCode e Equals */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aluno)) return false;

        Aluno aluno = (Aluno) o;

        if (getNome() != null ? !getNome().equals(aluno.getNome()) : aluno.getNome() != null) return false;
        if (getIdade() != null ? !getIdade().equals(aluno.getIdade()) : aluno.getIdade() != null) return false;
        if (getRg() != null ? !getRg().equals(aluno.getRg()) : aluno.getRg() != null) return false;
        if (getCpf() != null ? !getCpf().equals(aluno.getCpf()) : aluno.getCpf() != null) return false;
        return !(getEndereco() != null ? !getEndereco().equals(aluno.getEndereco()) : aluno.getEndereco() != null);

    }

    @Override
    public int hashCode() {
        int result = getNome() != null ? getNome().hashCode() : 0;
        result = 31 * result + (getIdade() != null ? getIdade().hashCode() : 0);
        result = 31 * result + (getRg() != null ? getRg().hashCode() : 0);
        result = 31 * result + (getCpf() != null ? getCpf().hashCode() : 0);
        result = 31 * result + (getEndereco() != null ? getEndereco().hashCode() : 0);
        return result;
    }
}
