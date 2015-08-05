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

    @SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", initialValue = 1)
    @GeneratedValue(generator = "seq_usuario", strategy = GenerationType.AUTO)
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;

        Usuario usuario = (Usuario) o;

        if (getId() != null ? !getId().equals(usuario.getId()) : usuario.getId() != null) return false;
        if (getNome() != null ? !getNome().equals(usuario.getNome()) : usuario.getNome() != null) return false;
        if (getLogin() != null ? !getLogin().equals(usuario.getLogin()) : usuario.getLogin() != null) return false;
        return !(getSenha() != null ? !getSenha().equals(usuario.getSenha()) : usuario.getSenha() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getNome() != null ? getNome().hashCode() : 0);
        result = 31 * result + (getLogin() != null ? getLogin().hashCode() : 0);
        result = 31 * result + (getSenha() != null ? getSenha().hashCode() : 0);
        return result;
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
