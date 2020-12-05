package projeto.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseDAO <VO> implements BaseInterDAO <VO>{ // Clase abstrata generica que será superclasse de todas as outras class
	Connection conn = null;
	private static final String URL = "jdbc:postgresql://localhost:5432/MedBay";
	private static final String USER = "postgres";
	private static final String SENHA = "riguinho123";
	
	public Connection getConnection() {
		if(conn == null) {
			try {
				conn = DriverManager.getConnection(URL, USER, SENHA);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}
		else
			return conn;
	}
	
	public abstract void cadastrar(VO vo) throws SQLException;
	public abstract void excluir(VO vo) throws SQLException;
	public abstract void editar(VO vo) throws SQLException;
	public abstract ResultSet listar() throws SQLException;
	public abstract ResultSet listarID(VO vo) throws SQLException;
	//public abstract ResultSet buscaCPF(VO vo) throws SQLException;
	//public abstract ResultSet buscaNome(VO vo) throws SQLException;
	//public abstract ResultSet busca(VO vo) throws SQLException;
}
