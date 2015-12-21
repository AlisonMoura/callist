package com.redick.persistencia.entidade;

import javax.persistence.*;

/**
 * Created by alisonmoura on 04/08/15.
 */
@Entity
public class Curso {

    @SequenceGenerator(name = "seq_curso", sequenceName = "seq_curso", initialValue = 1)
    @GeneratedValue(generator = "seq_curso", strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    private String titulo;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
