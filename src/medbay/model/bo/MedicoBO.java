package medbay.model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import medbay.model.dao.MedicoDAO;
import medbay.model.vo.MedicoVO;

public class MedicoBO implements MedicoInterBO{
	MedicoDAO<MedicoVO> dao = new MedicoDAO<MedicoVO>();
	
		public boolean cadastrar(MedicoVO medico) {
			try {
	    		dao.cadastrar(medico);
	    		return true;
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    		return false;
	    	}
			
		}
		
		public List<MedicoVO> listar() {
			ArrayList<MedicoVO> medicos = new ArrayList<MedicoVO>();
			try {
				ResultSet rs = dao.listar();
				while(rs.next()){
					MedicoVO vo = new MedicoVO();
					vo.setId(rs.getInt("ide"));
					vo.setNome(rs.getString("nome"));
					vo.setCpf(rs.getString("cpf"));
					vo.setIdade(rs.getInt("idade"));
					vo.setGenero(rs.getString("genero"));
					vo.setLogin(rs.getString("login"));
					vo.setSenha(rs.getString("senha"));
					vo.setEspecialidade(rs.getString("especialidade"));
					vo.setCrm(rs.getString("crm"));
					medicos.add(vo);
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
			return medicos;
		}
		
//		public void excluir(MedicoVO medico) {
//			// ir� receber um objeto do tipo MedicoVO com todos seus atributos e ser� excluido pelo usu�rio se o mesmo desejar.
//			// Como � um m�todo de exclus�o do banco de dados, vai est� ligado com o DAO, e n�o retorna nada al�m de uma mensagem 
//			// informado que a exclus�o foi feita com sucesso.
//			
//		}
//		
//		public MedicoVO editar(MedicoVO medico) {
//			// Receber� um objeto do tipo MedicoVO como parametro para posteriormente ter algum atributo alterado. 
//			// Todo e qualquer atributo alterado passar� por valida��o pelo m�todos get e set 
//			// Caso tenha algum atributo com valor invalido, uma mensagem de invalidez ser� mostrada para o usu�rio.
//			// Caso os valores estejam corretos, a mensagem de altera��o feita com sucesso aparecer� para o usu�rio.
//		}
//		
//		public MedicoVO buscaNome(MedicoVO medico) {
//			// Recebe uma string como parametro para buscar no banco de dados atrav�s do DAO um atributo nome que igual a string recebida 
//			// como parametro.
//			// Posteriormente ir� apresentar na tela um objeto medico correspondente a String recebida.
//			// Caso n�o exista nenhuma string igual, ir� exibir mensagem de nada encontrado.
//		}
//		
//		public MedicoVO buscaCPF(MedicoVO medico) {
//			// Ir� funcionar da mesma forma que o metodo de busca pelo nome, s� que ser� usado uma string com n�meros de cpf
//			// Obviamente ir� passar por uma valida��o para saber se o n�mero digitado � equivalente a um cpf, ou seja, 11 d�gitos.
//			// caso seja um cpf invalido ir� aparecer mensagem de invalidez na tela.
//			// Posteriormente ir� apresentar na tela um objeto medico correspondente a String recebida caso exista algum objeto 
//			// com cpf igual ao buscado.
//		}
//		
//		public MedicoVO buscaCRM(MedicoVO medico) {
//			//Ir� receber uma String como parametro e ir� passar pela valida��o, em seguida ir� manda para o DAO com a intens�o de verificar
//			//se existe algum valor na tabela igual a string recebedia por parametro, caso tenha ir� mostrar na tela para o usu�rio, caso
//			//n�o tenha a mensagem de medico n�o encontrado ser� exibido para o usu�rio;
//			
//		}
	
}
