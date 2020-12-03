package projeto.model.dao;

import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import projeto.model.vo.AtendenteVO;
import projeto.model.vo.GerenteVO;
import projeto.model.vo.MedicoVO;

public class GerenteDAO<VO extends GerenteVO> extends UsuarioDAO<VO>{
	
	public void cadastrar(VO vo) throws SQLException {
		conn = getConnection();
		String sql = "insert into Gerente(cpf, nome, idade, genero, login, senha) values (?, ?, ?, ?, ?, ?)";
		PreparedStatement ptst = conn.prepareStatement(sql);
		try {
			//ptst.setId()
			ptst.setString(1, vo.getCpf());
			ptst.setString(2, vo.getNome());
			ptst.setInt(3, vo.getIdade());
			ptst.setString(4, vo.getGenero());
			ptst.setString(5, vo.getLogin());
			ptst.setString(6, vo.getSenha());
			// DUVIDA: Como fazer o vo.getcpf_gerente;
			ptst.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void excluir(VO vo) throws SQLException{
		conn = getConnection();
		String sql = "delete from Gerente where ide_gerente = ?"; // revisar dps
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, vo.getId());
			ptst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editar(VO vo) throws SQLException {
		conn = getConnection();
		String sql = "update Gerente set nome = ?, idade = ?, genero = ? where ide_gerente = ?"; // revisar dps
		PreparedStatement ptst = conn.prepareStatement(sql);
		try {
			//ptst.setString(1, vo.getCpf());
			ptst.setString(1, vo.getNome());
			ptst.setInt(2, vo.getIdade());
			ptst.setString(3, vo.getGenero());
			ptst.setInt(5, vo.getId());
			ptst.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
	}
	
	public ArrayList<GerenteVO> listar() throws SQLException{
		String sql = "select * from Gerente";
		Statement st;
		ResultSet rs;
		ArrayList<GerenteVO> gerentes = new ArrayList<GerenteVO>();
		try {
			conn = getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
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
	
	public ArrayList<GerenteVO> listarNome(VO vo) throws SQLException{
		conn = getConnection();
		String sql = "select * from Gerente where nome =" + vo.getNome();
		Statement st;
		ResultSet rs;
		ArrayList<GerenteVO> gerentes = new ArrayList<GerenteVO>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				GerenteVO c = new GerenteVO();
				c.setId(rs.getInt("ide_gerente"));
				c.setCpf(rs.getString("cpf"));
				c.setNome(rs.getString("nome"));
				c.setIdade(rs.getInt("idade"));
				c.setGenero(rs.getString("genero"));
				c.setLogin(rs.getString("login"));
				c.setSenha(rs.getString("senha"));
				gerentes.add(c);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return gerentes;
	}
	
	public ArrayList<GerenteVO> listarCPF(VO vo) throws SQLException{
		conn = getConnection();
		String sql = "select * from Gerente where cpf =" + vo.getCpf();
		Statement st;
		ResultSet rs;
		ArrayList<GerenteVO> gerentes = new ArrayList<GerenteVO>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				GerenteVO c = new GerenteVO();
				c.setId(rs.getInt("ide_gerente"));
				c.setCpf(rs.getString("cpf"));
				c.setNome(rs.getString("nome"));
				c.setIdade(rs.getInt("idade"));
				c.setGenero(rs.getString("genero"));
				c.setLogin(rs.getString("login"));
				c.setSenha(rs.getString("senha"));
				gerentes.add(c);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return gerentes;
	}
	
	public ArrayList<GerenteVO> listarID(VO vo) throws SQLException{
		conn = getConnection();
		String sql = "select * from Gerente where ide_gerente =" + vo.getId();
		Statement st;
		ResultSet rs;
		ArrayList<GerenteVO> gerentes = new ArrayList<GerenteVO>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				GerenteVO c = new GerenteVO();
				c.setId(rs.getInt("ide_gerente"));
				c.setCpf(rs.getString("cpf"));
				c.setNome(rs.getString("nome"));
				c.setIdade(rs.getInt("idade"));
				c.setGenero(rs.getString("genero"));
				c.setLogin(rs.getString("login"));
				c.setSenha(rs.getString("senha"));
				gerentes.add(c);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return gerentes;
	}
}
