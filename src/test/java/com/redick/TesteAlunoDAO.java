package com.redick;

import com.redick.persistencia.dao.AlunoDAO;
import com.redick.persistencia.entidade.Aluno;
import com.redick.persistencia.entidade.Endereco;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by alisonmoura on 04/08/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/META-INF/spring-context.xml")
public class TesteAlunoDAO {

    @Autowired
    AlunoDAO dao;

    public Aluno getAluno(){

        Endereco endereco = new Endereco();

        endereco.setCidade("Campo Grande");
        endereco.setEstado("Mato Grosso do Sul");
        endereco.setBairro("Vila Nhá Nhá");
        endereco.setTipoLogradouro("Travessa");
        endereco.setLogradouro("Morte");
        endereco.setNumero(24);
        endereco.setCep("99999999");

        Aluno aluno = new Aluno();

        aluno.setNome("Joabe");
        aluno.setIdade(24);
        aluno.setRg("999999999");
        aluno.setCpf("99999999999");
        aluno.setEndereco(endereco);

        return aluno;
    }

    @Test
    public void testeSalvar(){
        dao.salvar(getAluno());
    }

}
