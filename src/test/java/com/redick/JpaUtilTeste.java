package com.redick;

import com.redick.persistencia.entidade.Usuario;
import com.redick.persistencia.entitymanager.JpaUtil;
import org.junit.Test;

import javax.persistence.EntityManager;

/**
 * Created by alisonmoura on 14/07/15.
 *
 * Classe feita para testar as funcionalidades da classe JpaUtil
 *
 * @author alisonmoura
 *
 *
 */
public class JpaUtilTeste {

    @Test
    public void teste(){

        //Instanciando e populando o Usuário
        Usuario usu = new Usuario();

        usu.setNome("Alison");
        usu.setLogin("alison");
        usu.setSenha("123");

        EntityManager entityManager = JpaUtil.getEntityManager();

        try {

            //Inicia a transação
            entityManager.getTransaction().begin();

            //faz a ação no DB
            entityManager.merge(usu);

            //Commit da transação
            entityManager.getTransaction().commit();

        }catch (Exception e){

            //Exibe a mensagem da exceção
            e.printStackTrace();

            //Se a entityManager estiver aberta: executa um rollback
            if(entityManager.isOpen()){
                entityManager.getTransaction().rollback();
            }
        }finally{
            //Se a entityManager estiver aberta: fecha a entityManager
            if(entityManager.isOpen()){
                entityManager.close();
            }
        }
    }

}
