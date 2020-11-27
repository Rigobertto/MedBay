package projeto.model.bo;

public class MedicoBO implements MedicoInterBO{
		public MedicoVO[] listar(MedicoVO medico) {
			
		}
	
		public MedicoVO cadastrar(MedicoVO medico) {
			// Vai receber valores para os atributos de medico incluindo os atributos herdados da classe Pessoa e mandar para o DAO
			// Os atributos vão passar pela validação, caso um ou mais esteja incorreto uma mensagem de erro irá aparecer para o usuário.
			// Irá retornar um objeto MedicoVO para o DAO
		}
		
		public void excluir(MedicoVO medico) {
			// irá receber um objeto do tipo MedicoVO com todos seus atributos e será excluido pelo usuário se o mesmo desejar.
			// Como é um método de exclusão do banco de dados, vai está ligado com o DAO, e não retorna nada além de uma mensagem 
			// informado que a exclusão foi feita com sucesso.
			
		}
		
		public MedicoVO editar(MedicoVO medico) {
			// Receberá um objeto do tipo MedicoVO como parametro para posteriormente ter algum atributo alterado. 
			// Todo e qualquer atributo alterado passará por validação pelo métodos get e set 
			// Caso tenha algum atributo com valor invalido, uma mensagem de invalidez será mostrada para o usuário.
			// Caso os valores estejam corretos, a mensagem de alteração feita com sucesso aparecerá para o usuário.
		}
		
		public MedicoVO buscaNome(MedicoVO medico) {
			// Recebe uma string como parametro para buscar no banco de dados através do DAO um atributo nome que igual a string recebida 
			// como parametro.
			// Posteriormente irá apresentar na tela um objeto medico correspondente a String recebida.
			// Caso não exista nenhuma string igual, irá exibir mensagem de nada encontrado.
		}
		
		public MedicoVO buscaCPF(MedicoVO medico) {
			// Irá funcionar da mesma forma que o metodo de busca pelo nome, só que será usado uma string com números de cpf
			// Obviamente irá passar por uma validação para saber se o número digitado é equivalente a um cpf, ou seja, 11 dígitos.
			// caso seja um cpf invalido irá aparecer mensagem de invalidez na tela.
			// Posteriormente irá apresentar na tela um objeto medico correspondente a String recebida caso exista algum objeto 
			// com cpf igual ao buscado.
		}
		
		public MedicoVO buscaCRM(MedicoVO medico) {
			//Irá receber uma String como parametro e irá passar pela validação, em seguida irá manda para o DAO com a intensão de verificar
			//se existe algum valor na tabela igual a string recebedia por parametro, caso tenha irá mostrar na tela para o usuário, caso
			//não tenha a mensagem de medico não encontrado será exibido para o usuário;
			
		}
	
}
