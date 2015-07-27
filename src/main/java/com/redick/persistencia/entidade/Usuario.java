package com.redick.persistencia.entidade;

import javax.persistence.*;

/**
 * Created by alisonmoura on 14/07/15.
 *
 * Classe modelo de Usuário
 *
 * @author alisonmoura
 *
 */

//@NamedQuery(name = "", query = "")

@Entity
public class Usuario {

    //Construtor padrão JPA
    public Usuario(){
    }


    @SequenceGenerator(name = "seq_usuario", initialValue = 1,sequenceName = "seq_usuario",allocationSize = 50)
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "seq_usuario")
    @Id
    private Integer id;
    private String nome;
    private String login;
    private String senha;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
