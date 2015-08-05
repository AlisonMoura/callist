package com.redick.persistencia.entidade;

import javax.persistence.*;

/**
 * Created by alisonmoura on 04/08/15.
 */
@Entity
public class AulaAluno {

    @SequenceGenerator(name = "seq_aula_aluno", sequenceName = "seq_aula_aluno", initialValue = 1)
    @GeneratedValue(generator = "seq_aula_aluno", strategy = GenerationType.AUTO)
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn
    private Aula aula;

    @ManyToOne
    @JoinColumn
    private Aluno aluno;

}
