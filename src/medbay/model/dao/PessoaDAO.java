package medbay.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import medbay.model.vo.PessoaVO;


public abstract class PessoaDAO<VO extends PessoaVO> extends BaseDAO<VO>{
	
	public abstract void cadastrar(VO vo) throws SQLException;
	public abstract void excluir(VO vo) throws SQLException;
	public abstract void editar(VO vo) throws SQLException;
	public abstract ResultSet listar() throws SQLException;
	public abstract ResultSet listarCPF(VO vo) throws SQLException;
	public abstract ResultSet listarNome(VO vo) throws SQLException;
	public abstract ResultSet listarID(VO vo) throws SQLException;
}
