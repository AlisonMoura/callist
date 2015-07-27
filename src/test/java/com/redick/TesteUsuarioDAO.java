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
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Collection;

/**
 * Created by alisonmoura on 19/07/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/spring-context.xml")
public class TesteUsuarioDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    UsuarioDAO dao;

    public Usuario getUsuario() {

        Usuario usu = new Usuario();

        usu.setNome("Alison");
        usu.setLogin("alison");
        usu.setSenha("123");

        return usu;
    }


    @Test
    @Transactional
    public void salvar() {

        Usuario usu = getUsuario();

        entityManager.merge(usu);

    }

    @Test
    @Transactional
    public void testeAutenticar() {

        Usuario usu = getUsuario();
        Usuario usuRetorno = null;

        String sql = "select Usuario from Usuario as usu where usu.login = :pLogin and usu.senha = :pSenha";

        try {

//            //Cria uma TypedQuery
//            TypedQuery<Usuario> query = entityManager.createQuery(sql, Usuario.class);

            Query query = entityManager.createQuery(sql);

            //Seta os parametros da query
            query.setParameter("pLogin", usu.getLogin());
            query.setParameter("pSenha", usu.getSenha());
            //Pega o objeto de retorno
            usuRetorno = (Usuario) query.getSingleResult();

        } catch (Exception e) {
            //imprime a excessão na tela
            e.printStackTrace();
        }


    }

}
