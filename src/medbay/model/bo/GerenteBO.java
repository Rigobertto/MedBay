package medbay.model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import medbay.model.dao.GerenteDAO;
import medbay.model.vo.GerenteVO;

public class GerenteBO implements GerenteInterBO{
	
	GerenteDAO<GerenteVO> dao = GerenteDAO<GerenteVO>();
	
	public List<GerenteVO> listar(GerenteVO gerente) {
		ArrayList<GerenteVO> gerentes = new ArrayList<GerenteVO>();
		try {
			ResultSet rs = dao.listar();
			while(rs.next()){
				GerenteVO vo = new GerenteVO();
				vo.setId(rs.getInt("ide_gerente"));
				vo.setCpf(rs.getString("cpf"));
				vo.setNome(rs.getString("nome"));
				vo.setIdade(rs.getInt("idade"));
				vo.setGenero(rs.getString("genero"));
				vo.setLogin(rs.getString("login"));
				vo.setSenha(rs.getString("senha"));
				gerentes.add(vo);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return gerentes;
	}
	
	public GerenteVO editar(GerenteVO gerente){
		
	}
	
	public void excluir(GerenteVO gerente){
	//	Recebe um objeto Pessoa para excluir, vale destacar que excluir� n�o s� apenas um atributo, mas sim o objeto por completo.
	//	N�o retorna nada.
	}
	
	public GerenteVO buscaCPF(GerenteVO gerente){
	//	Ir� receber uma String CPF para retornar o objeto do tipo Pessoa que tem como atributo igual a mesma String CPF
	//	recebida por parametro e poder retornar.
	//	Vale destacar que antes de ir para o m�todo de busca no DAO, a String recebida por parametro ir� passar por uma valida��o
	//	para saber se � de fato um n�mero de CPF;
	}
	
	public GerenteVO buscaNome(GerenteVO gerente){
		//	Ir� receber uma String nome para retornar o objeto do tipo Pessoa que tem como atributo igual a mesma String nome
		//	recebida por parametro e poder retornar a exibi��o dos atributos do objeto.
		//	Vale destacar que antes de ir para o m�todo de busca no DAO, a String recebida por parametro ir� passar por uma valida��o
		//	para saber se � de fato uma String nula e etc.
	}
	
	public GerenteVO cadastrar(GerenteVO gerente){
	//	Recebe um objeto Pessoa para inserir os atributos incluindo os inicializados pelo construtor e envia para o DAO e posteriormente
	//	inserir no banco de dados;
	//	Os atributos que ser�o cadastrados passar�o pela valida��o dos mesmo com os m�todos get e set correspondente a cada um,
	//	como idade, cpf, nome, genero e etc.
	}
}
