package com.redick.persistencia.entitymanager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by alisonmoura on 13/07/15.
 *
 * Classe para gerenciar as entregas dos entityManager's
 *
 * @author alisonmoura
 *
 */
public class JpaUtil {

    //Construtor
    private JpaUtil(){

    }

    //Nome da unidade de persistencia
    private static final String PERSISTENCE_UNIT_NAME = "CALLIST";

    //Thead que será armazenado para a transação do EntityManager
    private static ThreadLocal<EntityManager> threadEntityManager = new ThreadLocal<EntityManager>();

    //EntityManager
    private static EntityManagerFactory entityManagerFactory;

    //Metodo para pegar o entityManager

    /**
     *
     * @exception
     *
     * @return EntityManager entityManager
     */
    public static EntityManager getEntityManager(){

        //Se o entityManagerFactory está nulo, então istancia ele
        if(entityManagerFactory == null){
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }

        //Pega o entityManager a Thread atual
        EntityManager entityManager = threadEntityManager.get();

        //Se o entityManager estiver nulo, então instancia ele
        if(entityManager == null || !entityManager.isOpen()){
            entityManager = entityManagerFactory.createEntityManager();
            threadEntityManager.set(entityManager);
        }

        return entityManager;
    }

    //Método para fechar o entityManager
    public static void closeEntityManager(){

        //pega o entityManager da Thead
        EntityManager entityManager = threadEntityManager.get();

        //Se o entityManager for diferente de nulo
        if(entityManager != null){

            //pega a transação do entityManager
            EntityTransaction transaction = entityManager.getTransaction();

            //Se a transação estivar ativa, então dê um commit na transação
            if(transaction.isActive()){
                transaction.commit();
            }

            //fecha o entityManager
            entityManager.close();

            //set nullo no threadEntityManager
            threadEntityManager.set(null);
        }
    }

    //Método para fechar o entityManagerFactory
    public static void closeEntityManagerFactory(){

        //primeiro fecha o entityManager
        closeEntityManager();

        //fecha o entityManagerFactory
        entityManagerFactory.close();

    }
}
