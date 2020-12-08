package medbay.model.vo;

import java.util.Calendar;

public class ExameVO {
	private int id;
	private String nome;
	private float valor;

	public int getId() {
		return this.id;
	}

	public boolean setId(int id) {
		if(id < 0) return false;
		else this.id = id;
		return true;
	}

	public String getNome() {
		return this.nome;
	}

	public boolean setNome(String nome) {
		if(nome == null || nome.isEmpty()) return false;
		this.nome = nome.toUpperCase();
		return true;
	}

	public float getValor() {
		return this.valor;
	}

	public boolean setValor(float valor) {
		if(valor < 0.00f) return false;
		this.valor = valor;
		return true;
	}
}
