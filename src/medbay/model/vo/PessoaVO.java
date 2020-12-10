package medbay.model.vo;

import medbay.model.util.CPF;

public abstract class PessoaVO {
	private int id;
	private String nome;
	private int idade;
	private CPF cpf;
	private String genero;
	
	public int getId() {
		    return this.id;
	}
	public boolean setId(int id) {
		if(id < 0x00) return false;
		this.id = id;
		return true;
	}
	
	public String getNome() {
		return new String(this.nome);
	}
	public boolean setNome(String nome) {
		if(nome == null || nome.isEmpty()) return false;
		this.nome = new String(nome.toUpperCase());
		return true;
	}
	
	public int getIdade() {			
		return this.idade;
	}
	public boolean setIdade(int idade) {
		if(idade < 0) return false; // Provavelmente uma futura excepcion para idades menores que 0
		this.idade = idade;
		return true;
	}
	
	public String getCpf() {
		return new String(this.cpf.get());
	}
	public boolean setCpf(CPF cpf) {
		if(cpf.itsValid()) {
			this.cpf = new CPF(cpf.get());
			return true;
		}
		return false;
	}
	public boolean setCpf(String cpf) {
		return this.setCpf(new CPF(cpf));
	}

	public String getGenero() {
		return new String(this.genero);
	}
	public boolean setGenero(String genero) {
		genero = genero.toUpperCase();
		if(genero.equals("M") || genero.equals("F") || genero.equals("O")){
			this.genero = new String(genero);
			return true;
		}
		return false;
	}
}
