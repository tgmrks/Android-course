package com.example.ismael.aula7softblueadapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ismael on 13/07/15.
 */
public class Produto {

    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public static List<Produto> getProdutos (){

        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Café", 3.5));
        produtos.add(new Produto("Whisky", 17.5));
        produtos.add(new Produto("Baden Baden", 15.9));
        produtos.add(new Produto("Vinho", 7.2));
        produtos.add(new Produto("Chocolate", 4.0));
        produtos.add(new Produto("Água", 1.5));

        return produtos;
    }
}
