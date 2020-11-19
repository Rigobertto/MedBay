package projeto.model.bo;

public class PessoaBO {

	public Pessoa editarPessoa(PessoaVO pessoa){
	//	Recebe objeto do tipo pessoa que poderá editar cada atributo...
	//	...utilizando também os métodos get e set para exibir e enviar no DAO.
	//	Caso a o usuário nao escolha nenhum genero, o genero utilizado será o Indefinido, declarado já no construtor;
	//	Retorna um objeto do tipo Pessoa com os atributos editados.
	}
	
	public void excluirPessoa(PessoaVO pessoa){
	//	Recebe um objeto Pessoa para excluir, vale destacar que excluirá não só apenas um atributo, mas sim o objeto por completo.
	//	Não retorna nada.
	}
	
	public void buscaPessoaCPF(String CPF){
	//	Irá receber uma String CPF para retornar o objeto do tipo Pessoa que tem como atributo igual a mesma String CPF
	//	recebida por parametro e poder retornar.
	//	Vale destacar que antes de ir para o método de busca no DAO, a String recebida por parametro irá passar por uma validação
	//	para saber se é de fato um número de CPF;
	}
	
	public void buscaPessoaNome(String nome){
		//	Irá receber uma String nome para retornar o objeto do tipo Pessoa que tem como atributo igual a mesma String nome
		//	recebida por parametro e poder retornar a exibição dos atributos do objeto.
		//	Vale destacar que antes de ir para o método de busca no DAO, a String recebida por parametro irá passar por uma validação
		//	para saber se é de fato uma String nula e etc.
	}
	
	public void buscaPessoaID(){
		//	Irá receber um inteiro > 0 como parametro para retornar o objeto do tipo Pessoa que tem como atributo igual o mesmo inteiro
		//	recebido por parametro e poder retornar a exibição dos atributos do objeto.
		//	Vale destacar que antes de ir para o método de busca no DAO, o inteiro recebido por parametro irá passar por uma validação
		//	para saber se é de fato um inteiro > 0 ou de valor null.
	}
	
	public void CadastrarPessoa(PessoaVO pessoa){
	//	Recebe um objeto Pessoa para inserir os atributos incluindo os inicializados pelo construtor e envia para o DAO e posteriormente
	//	inserir no banco de dados;
	//	Os atributos que serão cadastrados passarão pela validação dos mesmo com os métodos get e set correspondente a cada um,
	//	como idade, cpf, nome, genero e etc.
	}
}
