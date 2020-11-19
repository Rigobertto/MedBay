package projeto.model.bo;

public class AtendenteBO {

	public AtendenteVO buscarAtendenteNome(String nome) {
		// Recebe uma string como parametro para buscar no banco de dados através do DAO um atributo nome que igual a string recebida 
		// como parametro.
		// Posteriormente irá apresentar na tela um objeto Atendente correspondente a String recebida.
		// Caso não exista nenhuma string igual, irá exibir mensagem de nada encontrado.
	}
	
	public AtendenteVO buscarAtendenteCPF(String CPF) {
		// Irá funcionar da mesma forma que o metodo de busca pelo nome, só que será usado uma string com números de cpf
		// Obviamente irá passar por uma validação para saber se o número digitado é equivalente a um cpf, ou seja 11 dígitos.
		// caso seja um cpf invalido irá aparecer mensagem de invalidez na tela.
		// Posteriormente irá apresentar na tela um objeto Atendente correspondente a String recebida caso exista algum objeto 
		// com cpf igual ao buscado.
	}
	
	public AtendenteVO cadastrarAtendente(AtendenteVO atendente) {
		// Vai receber valores para os atributos de atendente incluindo os atributos herdados da classe Pessoa e mandar para o DAO
		// Os atributos vão passar pela validação, caso 1 ou mais esteja incorreto uma mensagem de erro irá aparecer para o usuário.
		// Irá retornar uma pessoa para o DAO
	}
	
	public void excluirAtendente(AtendeteVO atendente) {
		// irá receber um objeto do tipo atendente com todos seus atributos e será excluido pelo usuário se o mesmo desejar.
		// Como é um método de exclusão do banco de dados, vai está ligado com o DAO, e não retorna nada além de uma mensagem 
		// informado que a exclusão foi feita com sucesso.
	}
	
	public AtendenteVO editarAtendente(AtendeteVO atendente) {
		// Receberá um objeto AtendetneVO como paranmetro para posteriormente ter algum atributo alterado. 
		// Todo e qualquer atributo alterado passará por validação pelo métodos get e set 
		// Caso tenha algum atributo com valor invalido, uma mensagem de invalidez será mostrada para o usuário.
		// Caso os valores estejam corretos, a mensagem de alteração feita com sucesso aparecerá para o usuário.
	}
}
