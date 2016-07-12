package com.example.ismael.aula15sofbluedatabase.data;

import java.io.Serializable;

/**
 * Created by ismael on 03/08/15.
 */
public class Produto implements Serializable {
                                //tem relação com a torca de dados com a intent

    private int id;
    private String nome;
    private double valor;

    //construtor do BEAN
    public Produto(int id, String nome, double valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }
    public Produto(String nome, double valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
