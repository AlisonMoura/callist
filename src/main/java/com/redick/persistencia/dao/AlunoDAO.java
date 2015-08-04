package com.redick.persistencia.dao;

import com.redick.persistencia.entidade.Aluno;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by alisonmoura on 04/08/15.
 */

@Repository
public class AlunoDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void salvar(Aluno aluno) {
        if (aluno != null) {
            entityManager.persist(aluno);
        }
    }

    @Transactional
    public void remover(Aluno aluno) {
        if (aluno != null && aluno.getId() > 0) {
            entityManager.remove(aluno);
        }
    }

    public List<Aluno> buscarTodos() {

        //Declarando a lista de alunos
        List<Aluno> listaAlunos;

        //Fazendo o SQL
        String sql = "select aluno from Aluno as aluno";

        //Cria a query
        Query query = entityManager.createQuery(sql);

        //pega o reasultado e armazena na variável listaAlunos
        listaAlunos = query.getResultList();

        return listaAlunos;
    }


}
