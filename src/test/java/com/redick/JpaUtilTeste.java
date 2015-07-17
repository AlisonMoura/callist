package com.redick;

import com.redick.persistencia.entidade.Aluno;
import com.redick.persistencia.entidade.Endereco;
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

        EntityManager entityManager = JpaUtil.getEntityManager();

        //Instanciando e populando um novo endereco
        Endereco endereco = new Endereco();
        endereco.setCep("99999999");
        endereco.setEstado("Mato Grosso do Sul");
        endereco.setCidade("Campo Grande");
        endereco.setBairro("Minha Quebrada");
        endereco.setLogradouro("Sem Fuga");
        endereco.setTipoLogradouro("Rua");
        endereco.setNumero(0);

        //Instanciando e populando o Aluno e o Endereco
        Aluno aluno =  new Aluno();
        aluno.setNome("Alison");
        aluno.setIdade(22);
        aluno.setCpf("999.999.999-99");
        aluno.setRg("999.999.999");
        aluno.setEndereco(endereco);

        try {

            //Inicia a transação
            entityManager.getTransaction().begin();

            //faz a ação no DB
            entityManager.merge(aluno);

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
