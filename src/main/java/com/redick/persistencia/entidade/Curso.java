package com.redick.persistencia.entidade;

import javax.persistence.*;
import java.util.List;

/**
 * Created by alisonmoura on 04/08/15.
 */
@Entity
public class Curso {

    @SequenceGenerator(name = "seq_curso", sequenceName = "seq_curso", initialValue = 1)
    @GeneratedValue(generator = "seq_curso", strategy = GenerationType.AUTO)
    @Id
    private Integer id;

    @OneToMany
    @JoinColumn
    private List<Aula> aulas;

}
