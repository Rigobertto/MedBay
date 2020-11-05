package projeto.model.vo;

public class Pessoa {
	private String nome;
	private int idade;
	private String cpf;
	private char genero;
	
	public String getNome() {
		if(nome == null) {
			nome = "";
			return nome;
		}
		else
			return nome;
	}
	
	public void setNome(String nome) {			//****Lembrando que a função isEmpty retorna verdadeiro se o .legth() == 0
		if(nome != null && !(nome.isEmpty()))	//caso os valores sejam verdadeiros será atribuido, mas antes da atribuição
			this.nome = nome.toUpperCase();		// tudo é convertido em maiúsculo.
		else
			System.out.println("Nome inválido ou vazio");
	}
	
	public int getIdade() {
		if(idade > 0)
			return idade;
		else
			return idade = 0; // Ou seja, se caso aparecer uma idade == 0, significa que a idade anteriormente 
	}							// era uma idade <= 0;
	
	public void setIdade(int idade) {
		if(idade > 0)
			this.idade = idade;
		else
			System.out.println("Idade inválida!");
	}
	
	public String getCpf(){
		if(cpf == null) {
			cpf = "";
			return cpf;
		}
		else
			return cpf;
	}
	
	public void setCpf(String cpf) {
		if(cpf.length() == 11 && cpf != null && !(cpf.isEmpty()))	// Por enquanto a validação do cpf está assim
			this.cpf = cpf;											// mas é necessário refinar essa validação
		else											//// *******AINDA NAO FINALIZADO*****
			System.out.println("CPF inválido!");
	}
	
	public char getGenero() {
		if(genero == 'M' || genero == 'F' || genero == 'f' || genero == 'm' || genero == 'i' || genero == 'I'){
			return genero;
		}
		else{
			genero = 'I';	//Caso o genero retornado seja diferete de M ou F,
			return genero; 	// independete do caractere será colocado como Indefinido (I/i);
		}
	}
	
	public void setGenero(char genero){
		if(genero == 'M' || genero == 'F' || genero == 'f' || genero == 'm' || genero == 'i' || genero == 'I')
			this.genero = genero;
		else
			System.out.println("Genero inválido!");
	}
}
