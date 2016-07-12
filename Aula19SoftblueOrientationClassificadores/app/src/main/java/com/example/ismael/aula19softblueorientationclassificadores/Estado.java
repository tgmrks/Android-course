package com.example.ismael.aula19softblueorientationclassificadores;

import java.io.Serializable;

/**
 * Created by ismael on 10/08/15.
 */
public class Estado implements Serializable {

    private String nome;
    private String sigla;

    public Estado(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }
}
