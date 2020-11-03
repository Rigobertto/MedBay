package projeto.model.vo;

public class Pessoa {
	private String nome;
	private int idade;
	private String cpf;
	private char genero;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		
			this.nome = nome.toUpperCase();
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		if(idade > 0)
			this.idade = idade;
		else
			System.out.println("Idade inválida!");
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		if(cpf.length() == 11)
			this.cpf = cpf;
		else
			System.out.println("CPF inválido!");
	}
	
	public char getGenero() {
		return genero;
	}
	
	public void setGenero(char genero) {
		if(genero == 'M' || genero == 'F' || genero == 'f' || genero == 'm' || genero == 'i' || genero == 'I')
			this.genero = genero;
		else
			System.out.println("Genero invpalido!");
	}
}
