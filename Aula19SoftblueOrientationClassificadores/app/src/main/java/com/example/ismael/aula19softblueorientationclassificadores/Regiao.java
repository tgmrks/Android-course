package com.example.ismael.aula19softblueorientationclassificadores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ismael on 10/08/15.
 */
public class Regiao implements Serializable {

    private String nome;
    private List<Estado> estados = new ArrayList<Estado>();

    public Regiao(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    @Override
    public String toString() {
        return nome;
    }

}
