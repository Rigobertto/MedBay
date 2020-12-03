package projeto.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface BaseInterDAO <VO> { //Classe interface que promete as classes genericas de BaseDAO COM AS EXCEPTIONS
	
	public void cadastrar(VO vo) throws SQLException;
	public void excluir(VO vo) throws SQLException;
	public void editar(VO vo) throws SQLException;
	public ArrayList<VO> listar() throws SQLException;
	public ArrayList<VO> listarID(VO vo) throws SQLException;
	////public ResultSet buscaCPF(VO vo) throws SQLException;
	//public ResultSet buscaNome(VO vo) throws SQLException;
	//public ResultSet busca(VO vo) throws SQLException;
	//public ResultSet buscaID(VO vo) throws SQLException;
}
