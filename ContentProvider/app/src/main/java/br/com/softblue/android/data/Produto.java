package br.com.softblue.android.data;

import java.io.Serializable;

public class Produto implements Serializable {

	private int id;
	private String nome;
	private double valor;

	public Produto(int id, String nome, double valor) {
		this.id = id;
		this.nome = nome;
		this.valor = valor;
	}

	public Produto(String nome, double valor) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produto produto = (Produto) o;

        return id == produto.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
