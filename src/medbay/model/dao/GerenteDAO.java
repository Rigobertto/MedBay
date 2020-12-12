package medbay.model.dao;

import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import medbay.model.vo.GerenteVO;
import medbay.model.vo.UsuarioVO;

public class GerenteDAO<VO extends GerenteVO> extends BaseDAO<VO>{
	
	public UsuarioVO autenticarGerente(UsuarioVO vo) {
		//conn = getConnection();
		String sqlVerificarLogin = "select * from Gerente where login = ?";// + vo.getLogin();
		//System.out.println(sqlVerificarLogin);
		PreparedStatement ptst;
		ResultSet rs;
		String login = vo.getLogin();
		UsuarioVO user = new GerenteVO();
		try {
			ptst = getConnection().prepareStatement(sqlVerificarLogin);
			ptst.setString(1, vo.getLogin());
			rs = ptst.executeQuery();
			if(rs.next()) {
				if(login.equals(rs.getString("login"))){
					user.setId(rs.getInt("ide"));
					user.setNome(rs.getString("nome"));
					user.setCpf(rs.getString("cpf"));
					user.setIdade(rs.getInt("idade"));
					user.setGenero(rs.getString("genero"));
					user.setLogin(rs.getString("login"));
					user.setSenha(rs.getString("senha"));
					user.setTabela(1);
					if(user.getSenha().equals(vo.getSenha())){
						return user;
					}else{
						user.setTabela(0);
						return user;
					}
				}else {
					user.setTabela(0);
					return user;
				}
			}else{
				user.setTabela(0);
				return user;
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
			return null;
		}
	}
	
	public void cadastrar(VO vo) throws SQLException {
		conn = getConnection();
		String sql = "insert into Gerente (cpf, nome, idade, genero, login, senha) values (?, ?, ?, ?, ?, ?)";
		PreparedStatement ptst = conn.prepareStatement(sql);
		try {
			ptst.setString(1, vo.getCpf());
			ptst.setString(2, vo.getNome());
			ptst.setInt(3, vo.getIdade());
			ptst.setString(4, vo.getGenero());
			ptst.setString(5, vo.getLogin());
			ptst.setString(6, vo.getSenha());
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
			ptst.setInt(4, vo.getId());
			ptst.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
	}
	
	public ResultSet listar() throws SQLException{
		conn = getConnection();
		String sql = "select * from Gerente";
		Statement st;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public GerenteVO buscarNome(GerenteVO vo) throws SQLException {
		conn = getConnection();
		String sqlSearch = "select * from Gerente where nome like ?";
		PreparedStatement ptst;
		ResultSet rs;
		GerenteVO gerente = new GerenteVO();
		try {
			ptst = conn.prepareStatement(sqlSearch);
			ptst.setString(1, vo.getNome());
			rs = ptst.executeQuery();
			if(rs.next()) {
				gerente.setId(rs.getInt("ide_gerente"));
				gerente.setNome(rs.getString("nome"));
				gerente.setCpf(rs.getString("cpf"));
				gerente.setIdade(rs.getInt("idade"));
				gerente.setGenero(rs.getString("genero"));
				gerente.setLogin(rs.getString("login"));
				gerente.setSenha(rs.getString("senha"));
			} else {
				System.out.println("Busca falhou, retornando nulo.");
				return null;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return gerente;
	}
	
	public GerenteVO buscarCPF(GerenteVO vo) throws SQLException {
		conn = getConnection();
		String sqlSearch = "select * from Gerente where cpf like ?";
		PreparedStatement ptst;
		ResultSet rs;
		GerenteVO gerente = new GerenteVO();
		try {
			ptst = conn.prepareStatement(sqlSearch);
			ptst.setString(1, vo.getCpf());
			rs = ptst.executeQuery();
			if(rs.next()) {
				gerente.setId(rs.getInt("ide_gerente"));
				gerente.setNome(rs.getString("nome"));
				gerente.setCpf(rs.getString("cpf"));
				gerente.setIdade(rs.getInt("idade"));
				gerente.setGenero(rs.getString("genero"));
				gerente.setLogin(rs.getString("login"));
				gerente.setSenha(rs.getString("senha"));
			} else {
				System.out.println("Busca falhou, retornando nulo.");
				return null;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return gerente;
	}
	
	public GerenteVO buscarID(GerenteVO vo) throws SQLException {
		conn = getConnection();
		String sqlSearch = "select * from Gerente where id_gerente like ?";
		PreparedStatement ptst;
		ResultSet rs;
		GerenteVO gerente = new GerenteVO();
		try {
			ptst = conn.prepareStatement(sqlSearch);
			ptst.setInt(1, vo.getId());
			rs = ptst.executeQuery();
			if(rs.next()) {
				gerente.setId(rs.getInt("ide_gerente"));
				gerente.setNome(rs.getString("nome"));
				gerente.setCpf(rs.getString("cpf"));
				gerente.setIdade(rs.getInt("idade"));
				gerente.setGenero(rs.getString("genero"));
				gerente.setLogin(rs.getString("login"));
				gerente.setSenha(rs.getString("senha"));
			} else {
				System.out.println("Busca falhou, retornando nulo.");
				return null;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return gerente;
	}
	
	/*public ResultSet listarNome(VO vo) throws SQLException{
		conn = getConnection();
		String sql = "select * from Gerente where nome =" + vo.getNome();
		Statement st;
		ResultSet rs = null;
		
		try {
			st = getConnection().createStatement();
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
		return rs;
	}*/
	
	/*public ResultSet listarCPF(VO vo) throws SQLException{
		conn = getConnection();
		String sql = "select * from Gerente where cpf =" + vo.getCpf();
		Statement st;
		ResultSet rs = null;
		//List<GerenteVO> gerentes = new ArrayList<GerenteVO>();
		try {
			st = getConnection().createStatement();
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
		return rs;
	}*/
	
	/*public ResultSet listarID(VO vo) throws SQLException{
		conn = getConnection();
		String sql = "select * from Gerente where ide_gerente =" + vo.getId();
		Statement st;
		ResultSet rs = null;
		//List<GerenteVO> gerentes = new ArrayList<GerenteVO>();
		try {
			st = getConnection().createStatement();
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
		return rs;
	}*/
}
