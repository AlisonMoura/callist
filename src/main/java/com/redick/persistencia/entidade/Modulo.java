package com.redick.persistencia.entidade;

import javax.persistence.*;
import java.util.List;

/**
 * Created by alisonmoura on 04/08/15.
 */
@Entity
public class Modulo {

    @SequenceGenerator(name = "seq_modulo", sequenceName = "seq_modulo", initialValue = 1)
    @GeneratedValue(generator = "seq_modulo", strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    @ManyToOne
    @JoinColumn
    private Curso curso;
    @ManyToOne
    @JoinColumn
    private Turma turma;
    @OneToMany
    @JoinColumn
    private List<Aula> aulas;

}
