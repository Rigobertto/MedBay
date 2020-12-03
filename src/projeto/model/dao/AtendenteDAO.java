package projeto.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import projeto.model.vo.AtendenteVO;

public class AtendenteDAO<VO extends AtendenteVO> extends UsuarioDAO<VO> {
	public void cadastrar(VO vo) throws SQLException {
		conn = getConnection();
		String sql = "insert into Atendente(cpf, nome, idade, genero, login, senha) values (?, ?, ?, ?, ?, ?)";
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
		String sql = "delete from Atendente where ide_atendente = ?"; // revisar dps
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
		String sql = "update Atendente set nome = ?, idade = ?, genero = ? where ide_atendente = ?"; // revisar dps
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
	
	public ArrayList<AtendenteVO> listar() throws SQLException{
		conn = getConnection();
		String sql = "select * from Atendente";;
		Statement st;
		ResultSet rs;
		ArrayList<AtendenteVO> atendentes = new ArrayList<AtendenteVO>();
		try {
			//conn = getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				AtendenteVO vo = new AtendenteVO();
				vo.setId(rs.getInt("ide_gerente"));
				vo.setCpf(rs.getString("cpf"));
				vo.setNome(rs.getString("nome"));
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
	
	public ArrayList<AtendenteVO> listarNome(VO vo) throws SQLException{
		conn = getConnection();
		String sql = "select * from Atendente where nome =" + vo.getNome();
		Statement st;
		ResultSet rs;
		ArrayList<AtendenteVO> atendentes = new ArrayList<AtendenteVO>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				AtendenteVO c = new AtendenteVO();
				c.setId(rs.getInt("ide_gerente"));
				c.setCpf(rs.getString("cpf"));
				c.setNome(rs.getString("nome"));
				c.setIdade(rs.getInt("idade"));
				c.setGenero(rs.getString("genero"));
				c.setLogin(rs.getString("login"));
				c.setSenha(rs.getString("senha"));
				atendentes.add(c);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return atendentes;
		
	}
	
	public ArrayList<AtendenteVO> listarCPF(VO vo) throws SQLException{
		conn = getConnection();
		String sql = "select * from Atendente where cpf =" + vo.getCpf();
		Statement st;
		ResultSet rs;
		ArrayList<AtendenteVO> atendentes = new ArrayList<AtendenteVO>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				AtendenteVO c = new AtendenteVO();
				c.setId(rs.getInt("ide_atendente"));
				c.setCpf(rs.getString("cpf"));
				c.setNome(rs.getString("nome"));
				c.setIdade(rs.getInt("idade"));
				c.setGenero(rs.getString("genero"));
				c.setLogin(rs.getString("login"));
				c.setSenha(rs.getString("senha"));
				atendentes.add(c);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return atendentes;
		
	}
	
	public ArrayList<AtendenteVO> listarID(VO vo) throws SQLException{
		conn = getConnection();
		String sql = "select * from Atendente where ide_atendente =" + vo.getId();
		Statement st;
		ResultSet rs;
		ArrayList<AtendenteVO> atendentes = new ArrayList<AtendenteVO>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				AtendenteVO c = new AtendenteVO();
				c.setId(rs.getInt("ide_atendente"));
				c.setCpf(rs.getString("cpf"));
				c.setNome(rs.getString("nome"));
				c.setIdade(rs.getInt("idade"));
				c.setGenero(rs.getString("genero"));
				c.setLogin(rs.getString("login"));
				c.setSenha(rs.getString("senha"));
				atendentes.add(c);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return atendentes;
	}
}
