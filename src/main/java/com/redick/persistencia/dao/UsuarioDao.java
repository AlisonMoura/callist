package com.redick.persistencia.dao;

import com.redick.persistencia.entidade.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

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

    public List<Usuario> buscarTodos() throws NoResultException{

        Query query = entityManager.createQuery("Select usu from Usuario as usu");
        List<Usuario> lista = (List<Usuario>) query.getResultList();

        return lista;
    }

}
