package medbay.model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import medbay.model.dao.PacienteDAO;
import medbay.model.vo.PacienteVO;

public class PacienteBO implements PacienteInterBO{
	PacienteDAO<PacienteVO> dao = new PacienteDAO<PacienteVO>();
	public boolean cadastrar(PacienteVO paciente) {
		try {
    		dao.cadastrar(paciente);
    		return true;
    	}catch(SQLException e) {
    		e.printStackTrace();
    		return false;
    	}
		
	}
	
	public List<PacienteVO> listar() {
		ArrayList<PacienteVO> pacientes = new ArrayList<PacienteVO>();
		try {
			ResultSet rs = dao.listar();
			while(rs.next()){
				PacienteVO vo = new PacienteVO();
				vo.setId(rs.getInt("ide"));
				vo.setNome(rs.getString("nome"));
				vo.setCpf(rs.getString("cpf"));
				vo.setIdade(rs.getInt("idade"));
				vo.setGenero(rs.getString("genero"));
				vo.setAltura(rs.getFloat("altura"));
				vo.setPeso(rs.getFloat("peso"));
				vo.setTipoSangue(rs.getString("sangue"));
				pacientes.add(vo);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return pacientes;
	}
	
//	public PacienteVO editar(PacienteVO paciente){
//	//	Recebe objeto do tipo pessoa que poder� editar cada atributo...
//	//	...utilizando tamb�m os m�todos get e set para exibir e enviar no DAO.
//	//	Caso a o usu�rio nao escolha nenhum genero, o genero utilizado ser� o Indefinido, declarado j� no construtor;
//	//	Retorna um objeto do tipo Pessoa com os atributos editados.
//	}
//	
//	public void excluir(PacienteVO paciente){
//	//	Recebe um objeto Pessoa para excluir, vale destacar que excluir� n�o s� apenas um atributo, mas sim o objeto por completo.
//	//	N�o retorna nada.
//	}
//	
//	public PacienteVO buscaCPF(PacienteVO paciente){
//	//	Ir� receber uma String CPF para retornar o objeto do tipo Pessoa que tem como atributo igual a mesma String CPF
//	//	recebida por parametro e poder retornar.
//	//	Vale destacar que antes de ir para o m�todo de busca no DAO, a String recebida por parametro ir� passar por uma valida��o
//	//	para saber se � de fato um n�mero de CPF;
//	}
//	
//	public PacienteVO buscaNome(PacienteVO paciente){
//		//	Ir� receber uma String nome para retornar o objeto do tipo Pessoa que tem como atributo igual a mesma String nome
//		//	recebida por parametro e poder retornar a exibi��o dos atributos do objeto.
//		//	Vale destacar que antes de ir para o m�todo de busca no DAO, a String recebida por parametro ir� passar por uma valida��o
//		//	para saber se � de fato uma String nula e etc.
//	}
	
}
