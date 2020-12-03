package projeto.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import projeto.model.vo.PessoaVO;


public abstract class PessoaDAO<VO extends PessoaVO> extends BaseDAO<VO>{
	
	public abstract void cadastrar(VO vo) throws SQLException;
	public abstract void excluir(VO vo) throws SQLException;
	public abstract void editar(VO vo) throws SQLException;
	public abstract ArrayList<VO> listar() throws SQLException;
	public abstract ArrayList<VO> listarCPF(VO vo) throws SQLException;
	public abstract ArrayList<VO> listarNome(VO vo) throws SQLException;
	public abstract ArrayList<VO> listarID(VO vo) throws SQLException;
}
