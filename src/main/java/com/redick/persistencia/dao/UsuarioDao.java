package com.redick.persistencia.dao;

import com.redick.persistencia.entidade.Usuario;
import com.redick.persistencia.entitymanager.JpaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;

/**
 * Created by alisonmoura on 19/07/15.
 */

@Repository
public class UsuarioDAO {

    //Pega o EntityManager
    @PersistenceContext
    private EntityManager entityManager;

    public UsuarioDAO() {

    }

    @Transactional
    public void salvar(Usuario usu) {

        //pede ao entityManager fazer um merge no usuário de parâmetro
        entityManager.merge(usu);

    }

    public Usuario autenticar(Usuario usu) throws NoResultException{

            Query consulta = entityManager.createQuery("Select u from Usuario u where u.login=:pLogin and u.senha=:pSenha");

            consulta.setParameter("pLogin", usu.getLogin());
            consulta.setParameter("pSenha", usu.getSenha());
            consulta.setMaxResults(1);

            return (Usuario) consulta.getSingleResult();

    }


}
