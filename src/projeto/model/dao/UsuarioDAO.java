package projeto.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projeto.model.vo.UsuarioVO;
public class UsuarioDAO <VO extends UsuarioVO> extends PessoaDAO<VO>{ // PRATICAMENTE FEITO MAS AINDA PRECISA FAZER VERIFICAÇÕES NO BANCO
	
	public  void cadastrar(VO vo) throws SQLException{
		
	}
	
	public void excluir(VO vo) throws SQLException{
		
	}
	
	public void editar(VO vo) throws SQLException{
		
	}
	
	public  ResultSet listar() throws SQLException{
		return  null ;
	}
	
	public ResultSet listarID(VO vo) throws SQLException{
		return  null ;
	}
	
	public ResultSet listarNome(VO vo) throws SQLException{
		return  null;
	}
	
	public ResultSet listarCPF(VO vo) throws SQLException{
		return  null;
	}
}
