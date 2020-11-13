package projeto.model.vo;

public class Pessoa {
	private String nome;
	private int idade;
	private String cpf;
	private char genero;
	
	public String getNome() {
		return new String(this.nome);
	}
	
	public boolean setNome(String nome) {
		if(nome == null || nome.isEmpty()) return false;
		this.nome = nome.toUpperCase();
		return true;
	}
	
	public int getIdade() {
		return this.idade;
	}
	
	public boolean setIdade(int idade) {
		if(idade < 0) return false;
		this.idade = idade;
		return true;
	}
	
	public String getCpf() {
		return new String(this.cpf);
	}
	
	public boolean setCpf(String cpf) {
		if(cpf.length() != 11) return false;
		this.cpf = cpf;
		return true;
	}
	
	public char getGenero() {
		return this.genero;
	}
	
	public boolean setGenero(char genero) {
		if(genero == 'M' || genero == 'F' || genero == 'f' || genero == 'm' || genero == 'i' || genero == 'I') {
			this.genero = genero;
			return true;
		}
		return false;
	}
}
