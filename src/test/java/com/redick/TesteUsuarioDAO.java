package com.redick;

import com.redick.persistencia.dao.UsuarioDAO;
import com.redick.persistencia.entidade.Usuario;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

/**
 * Created by alisonmoura on 19/07/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/spring-context.xml")
public class TesteUsuarioDAO {

    @PersistenceContext
    EntityManager entityManager;

    public Usuario getUsuario(){

        Usuario usu = new Usuario();

        usu.setNome("Siclano");
        usu.setLogin("sisi");
        usu.setSenha("123");

        return usu;
    }


    @Test
    @Transactional
    public void salvar() {

        Usuario usu = getUsuario();

        try {


            entityManager.merge(usu);


        } catch (Exception e) {

            e.printStackTrace();

            if (entityManager.getTransaction().isActive() || entityManager.isOpen()) {

                entityManager.getTransaction().rollback();

            }

        } finally {

            if (entityManager.isOpen()) {
                entityManager.close();
            }

        }

    }

}
