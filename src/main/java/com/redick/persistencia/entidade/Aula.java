package com.redick.persistencia.entidade;

import javax.persistence.*;

/**
 * Created by alisonmoura on 04/08/15.
 */

@Entity
public class Aula {



    @SequenceGenerator(name = "seq_aula", sequenceName = "seq_aula", initialValue = 1)
    @GeneratedValue(generator = "seq_aula", strategy = GenerationType.AUTO)
    @Id
    private Integer id;

}
