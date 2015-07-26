package com.redick.persistencia.dao;

import com.redick.persistencia.entidade.Usuario;
import com.redick.persistencia.entitymanager.JpaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 * Created by alisonmoura on 19/07/15.
 */

@Repository
public class UsuarioDAO {

    //Pega o EntityManager
    private EntityManager entityManager = JpaUtil.getEntityManager();

    public UsuarioDAO(){

    }

    @Transactional
    public void salvar(Usuario usu){

        try {

            entityManager.getTransaction().begin();

            entityManager.merge(usu);

            entityManager.getTransaction().commit();

        }catch (Exception e){

            e.printStackTrace();

            if(entityManager.getTransaction().isActive() || entityManager.isOpen()){

                entityManager.getTransaction().rollback();

            }

        }finally {

            if(entityManager.isOpen()){
                entityManager.close();
            }

        }

    }

}
