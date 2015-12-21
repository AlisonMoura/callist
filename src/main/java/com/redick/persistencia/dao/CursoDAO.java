package com.redick.persistencia.dao;

import com.redick.persistencia.entidade.Curso;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by alisonmoura on 05/08/15.
 */
@Repository
public class CursoDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void salvar(Curso curso){
        entityManager.merge(curso);
    }

    public List<Curso> buscarTodos(){

        List listaCursos;

        //sql
        String sql = "select c from Curso as c";

        //Criando a query de consulta
        Query query = entityManager.createQuery(sql);

        //armazenando o retorno da query no listaCursos
        listaCursos = (List) query.getResultList();

        return listaCursos;
    }

}
