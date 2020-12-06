package medbay.model.bo;

public class MedicoBO implements MedicoInterBO{
		public MedicoVO[] listar(MedicoVO medico) {
			
		}
	
		public MedicoVO cadastrar(MedicoVO medico) {
			// Vai receber valores para os atributos de medico incluindo os atributos herdados da classe Pessoa e mandar para o DAO
			// Os atributos v�o passar pela valida��o, caso um ou mais esteja incorreto uma mensagem de erro ir� aparecer para o usu�rio.
			// Ir� retornar um objeto MedicoVO para o DAO
		}
		
		public void excluir(MedicoVO medico) {
			// ir� receber um objeto do tipo MedicoVO com todos seus atributos e ser� excluido pelo usu�rio se o mesmo desejar.
			// Como � um m�todo de exclus�o do banco de dados, vai est� ligado com o DAO, e n�o retorna nada al�m de uma mensagem 
			// informado que a exclus�o foi feita com sucesso.
			
		}
		
		public MedicoVO editar(MedicoVO medico) {
			// Receber� um objeto do tipo MedicoVO como parametro para posteriormente ter algum atributo alterado. 
			// Todo e qualquer atributo alterado passar� por valida��o pelo m�todos get e set 
			// Caso tenha algum atributo com valor invalido, uma mensagem de invalidez ser� mostrada para o usu�rio.
			// Caso os valores estejam corretos, a mensagem de altera��o feita com sucesso aparecer� para o usu�rio.
		}
		
		public MedicoVO buscaNome(MedicoVO medico) {
			// Recebe uma string como parametro para buscar no banco de dados atrav�s do DAO um atributo nome que igual a string recebida 
			// como parametro.
			// Posteriormente ir� apresentar na tela um objeto medico correspondente a String recebida.
			// Caso n�o exista nenhuma string igual, ir� exibir mensagem de nada encontrado.
		}
		
		public MedicoVO buscaCPF(MedicoVO medico) {
			// Ir� funcionar da mesma forma que o metodo de busca pelo nome, s� que ser� usado uma string com n�meros de cpf
			// Obviamente ir� passar por uma valida��o para saber se o n�mero digitado � equivalente a um cpf, ou seja, 11 d�gitos.
			// caso seja um cpf invalido ir� aparecer mensagem de invalidez na tela.
			// Posteriormente ir� apresentar na tela um objeto medico correspondente a String recebida caso exista algum objeto 
			// com cpf igual ao buscado.
		}
		
		public MedicoVO buscaCRM(MedicoVO medico) {
			//Ir� receber uma String como parametro e ir� passar pela valida��o, em seguida ir� manda para o DAO com a intens�o de verificar
			//se existe algum valor na tabela igual a string recebedia por parametro, caso tenha ir� mostrar na tela para o usu�rio, caso
			//n�o tenha a mensagem de medico n�o encontrado ser� exibido para o usu�rio;
			
		}
	
}
