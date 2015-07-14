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

@Entity
public class Usuario {

    //Construtor padrão JPA
    public Usuario(){
    }


    @SequenceGenerator(name = "seq_usuario", initialValue = 1,sequenceName = "seq_usuario")
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "seq_usuario")
    @Id
    private Integer id;
    private String nome;
    private String login;
    private String senha;

    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
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
}
