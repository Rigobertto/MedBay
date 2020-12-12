package medbay.model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import medbay.model.dao.AtendenteDAO;
import medbay.model.vo.AtendenteVO;

public class AtendenteBO implements AtendenteInterBO {
	AtendenteDAO<AtendenteVO> dao = new AtendenteDAO<AtendenteVO>();
	
	public boolean cadastrar(AtendenteVO atendente) {
    	try {
    		dao.cadastrar(atendente);
    		return true;
    	}catch(SQLException e) {
    		e.printStackTrace();
    		return false;
    	}
    }
	
	public List<AtendenteVO> listar() {
		ArrayList<AtendenteVO> atendentes = new ArrayList<AtendenteVO>();
		try {
			ResultSet rs = dao.listar();
			while(rs.next()){
				AtendenteVO vo = new AtendenteVO();
				vo.setId(rs.getInt("ide"));
				vo.setNome(rs.getString("nome"));
				vo.setCpf(rs.getString("cpf"));
				vo.setIdade(rs.getInt("idade"));
				vo.setGenero(rs.getString("genero"));
				vo.setLogin(rs.getString("login"));
				vo.setSenha(rs.getString("senha"));
				atendentes.add(vo);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return atendentes;
	}
	
	public boolean editar(AtendenteVO atendente){
		try {
			dao.editar(atendente);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean excluir(AtendenteVO atendente){
		try {
			dao.excluir(atendente);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
//	
//	public AtendenteVO buscaCPF(AtendenteVO atendente){
//	//	Ir� receber uma String CPF para retornar o objeto do tipo Pessoa que tem como atributo igual a mesma String CPF
//	//	recebida por parametro e poder retornar.
//	//	Vale destacar que antes de ir para o m�todo de busca no DAO, a String recebida por parametro ir� passar por uma valida��o
//	//	para saber se � de fato um n�mero de CPF;
//	}
//	
//	public AtendenteVO buscaNome(AtendenteVO atendente){
//		//	Ir� receber uma String nome para retornar o objeto do tipo Pessoa que tem como atributo igual a mesma String nome
//		//	recebida por parametro e poder retornar a exibi��o dos atributos do objeto.
//		//	Vale destacar que antes de ir para o m�todo de busca no DAO, a String recebida por parametro ir� passar por uma valida��o
//		//	para saber se � de fato uma String nula e etc.
//	}
	
}
