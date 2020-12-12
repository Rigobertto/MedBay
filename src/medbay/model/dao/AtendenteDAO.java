package medbay.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import medbay.model.vo.AtendenteVO;
import medbay.model.vo.UsuarioVO;


public class AtendenteDAO<VO extends AtendenteVO> extends BaseDAO<VO> {
	
	public UsuarioVO autenticarAtendente(UsuarioVO vo) {
		//conn = getConnection();
		String sqlVerificarLogin = "select * from Atendente where login = ?";// + vo.getLogin();
		//System.out.println(sqlVerificarLogin);
		PreparedStatement ptst;
		ResultSet rs = null;
		String login = vo.getLogin();
		UsuarioVO user = new AtendenteVO();
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
					user.setTabela(2);
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
		String sqlVerificarLogin = "select login from Gerente union select login from Atendente union select login from Medico";
		PreparedStatement ptst;
		ResultSet rs;
		String login = vo.getLogin();
		
		try {
			ptst = getConnection().prepareStatement(sqlVerificarLogin);
			rs = ptst.executeQuery();
			while(rs.next()) {
				if(login.equals(rs.getString("login"))){ //para caso o login já exista
					System.out.println("O Login já existe, insira um novo!");
					return;
				}
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		
		String sqlInsert = "insert into Atendente (nome, cpf, idade, genero, login, senha) values (?, ?, ?, ?, ?, ?)";
		PreparedStatement ptst2;
		try {
			ptst2 = getConnection().prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
			ptst2.setString(1, vo.getNome());
			ptst2.setString(2, vo.getCpf());
			ptst2.setInt(3, vo.getIdade());
			ptst2.setString(4, vo.getGenero());
			ptst2.setString(5, vo.getLogin());
			ptst2.setString(6, vo.getSenha());
			
			int affectedRolls = ptst2.executeUpdate();
			
			if(affectedRolls == 0) {
				System.out.println("Falha em cadastrar o usuário");
				return;
			}
			
			ResultSet chave = ptst2.getGeneratedKeys();
			if(chave.next()) {
				vo.setId(chave.getInt(1));
			} else {
				System.out.println("Falha ao obter Id de usuário cadastrado.");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void excluir(VO vo) throws SQLException{
		conn = getConnection();
		String sql = "delete from Atendente where ide = ?"; // revisar dps
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
		String sql = "update Atendente set nome = ?, idade = ?, genero = ?, login = ?, senha = ? where ide = ?";
		PreparedStatement ptst = conn.prepareStatement(sql);
		try {
			ptst.setString(1, vo.getNome());
			ptst.setInt(2, vo.getIdade());
			ptst.setString(3, vo.getGenero());
			ptst.setString(4, vo.getLogin());
			ptst.setString(5, vo.getSenha());
			ptst.setInt(6, vo.getId());
			ptst.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
	}
	
	public AtendenteVO buscarNome(AtendenteVO vo) throws SQLException {
		conn = getConnection();
		String sqlSearch = "select * from Atendente where nome like ?";
		PreparedStatement ptst;
		ResultSet rs;
		AtendenteVO atendente = new AtendenteVO();
		try {
			ptst = conn.prepareStatement(sqlSearch);
			ptst.setString(1, vo.getNome());
			rs = ptst.executeQuery();
			if(rs.next()) {
				atendente.setId(rs.getInt("ide"));
				atendente.setNome(rs.getString("nome"));
				atendente.setCpf(rs.getString("cpf"));
				atendente.setIdade(rs.getInt("idade"));
				atendente.setGenero(rs.getString("genero"));
				atendente.setLogin(rs.getString("login"));
				atendente.setSenha(rs.getString("senha"));
			} else {
				System.out.println("Busca falhou, retornando nulo.");
				return null;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return atendente;
	}
	
	public AtendenteVO buscarCPF(AtendenteVO vo) throws SQLException {
		conn = getConnection();
		String sqlSearch = "select * from Atendente where cpf like ?";
		PreparedStatement ptst;
		ResultSet rs;
		AtendenteVO atendente = new AtendenteVO();
		try {
			ptst = conn.prepareStatement(sqlSearch);
			ptst.setString(1, vo.getCpf());
			rs = ptst.executeQuery();
			if(rs.next()) {
				atendente.setId(rs.getInt("ide"));
				atendente.setNome(rs.getString("nome"));
				atendente.setCpf(rs.getString("cpf"));
				atendente.setIdade(rs.getInt("idade"));
				atendente.setGenero(rs.getString("genero"));
				atendente.setLogin(rs.getString("login"));
				atendente.setSenha(rs.getString("senha"));
			} else {
				System.out.println("Busca falhou, retornando nulo.");
				return null;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return atendente;
	}
	
	public AtendenteVO buscarID(AtendenteVO vo) throws SQLException {
		conn = getConnection();
		String sqlSearch = "select * from Atendente where id_atendente like ?";
		PreparedStatement ptst;
		ResultSet rs;
		AtendenteVO atendente = new AtendenteVO();
		try {
			ptst = conn.prepareStatement(sqlSearch);
			ptst.setInt(1, vo.getId());
			rs = ptst.executeQuery();
			if(rs.next()) {
				atendente.setId(rs.getInt("ide"));
				atendente.setNome(rs.getString("nome"));
				atendente.setCpf(rs.getString("cpf"));
				atendente.setIdade(rs.getInt("idade"));
				atendente.setGenero(rs.getString("genero"));
				atendente.setLogin(rs.getString("login"));
				atendente.setSenha(rs.getString("senha"));
			} else {
				System.out.println("Busca falhou, retornando nulo.");
				return null;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return atendente;
	}
	
	public ResultSet listar() {
		conn = getConnection();
		String sql = "select * from Atendente";
		PreparedStatement st;
		ResultSet rs = null;
		try {
			st = getConnection().prepareStatement(sql);
			rs = st.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	/*public ArrayList<AtendenteVO> listarNome(VO vo) throws SQLException{
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
	}*/
}
