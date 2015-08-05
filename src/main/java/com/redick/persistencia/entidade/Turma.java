package com.redick.persistencia.entidade;

import javax.persistence.*;

/**
 * Created by alisonmoura on 04/08/15.
 */
@Entity
public class Turma {

    @SequenceGenerator(name = "seq_turma", sequenceName = "seq_turma", initialValue = 1)
    @GeneratedValue(generator = "seq_turma", strategy = GenerationType.AUTO)
    @Id
    private Integer id;

}
