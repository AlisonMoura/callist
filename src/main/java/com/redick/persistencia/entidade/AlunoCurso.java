package com.redick.persistencia.entidade;

import javax.persistence.*;

/**
 * Created by alisonmoura on 04/08/15.
 */
@Entity
public class AlunoCurso {

    @SequenceGenerator(name = "seq_aluno_curso", sequenceName = "seq_aluno_curso", initialValue = 1)
    @GeneratedValue(generator = "seq_aluno_curso", strategy = GenerationType.AUTO)
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn
    private Curso curso;

    @ManyToOne
    @JoinColumn
    private Aluno aluno;

}
