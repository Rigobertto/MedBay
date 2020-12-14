package medbay.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import medbay.model.vo.MedicoVO;
import medbay.model.vo.UsuarioVO;

public class MedicoDAO<VO extends MedicoVO> extends BaseDAO <VO> {
	
	public UsuarioVO autenticarMedico(UsuarioVO vo) {
		//conn = getConnection();
		String sqlVerificarLogin = "select * from Medico where login = ?";// + vo.getLogin();
		//System.out.println(sqlVerificarLogin);
		PreparedStatement ptst;
		ResultSet rs = null;
		String login = vo.getLogin();
		UsuarioVO user = new MedicoVO();
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
					user.setTabela(3);
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
		
		String sqlInsert = "insert into Medico (nome, cpf, idade, genero, login, "
				+ "senha, especialidade, crm) values (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ptst2;
		try {
			ptst2 = getConnection().prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
			ptst2.setString(1, vo.getNome());
			ptst2.setString(2, vo.getCpf());
			ptst2.setInt(3, vo.getIdade());
			ptst2.setString(4, vo.getGenero());
			ptst2.setString(5, vo.getLogin());
			ptst2.setString(6, vo.getSenha());
			ptst2.setString(7, vo.getEspecialidade());
			ptst2.setString(8, vo.getCrm());
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
		String sql = "delete from Medico where ide = ?";
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
		String sql = "update Medico set nome = ?, idade = ?, genero = ?, login = ?, senha = ?, especialidade = ? where ide = ?"; // revisar dps
		PreparedStatement ptst = conn.prepareStatement(sql);
		try {
			ptst.setString(1, vo.getNome());
			ptst.setInt(2, vo.getIdade());
			ptst.setString(3, vo.getGenero());
			ptst.setString(4, vo.getLogin());
			ptst.setString(5, vo.getSenha());
			ptst.setString(6, vo.getEspecialidade());
			ptst.setInt(7, vo.getId());
			ptst.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
	}
	
	public MedicoVO buscarCPF(MedicoVO vo) throws SQLException {
		conn = getConnection();
		String sqlSearch = "select * from Medico where cpf = ?";
		PreparedStatement ptst;
		ResultSet rs;
		MedicoVO medico = new MedicoVO();
		try {
			ptst = conn.prepareStatement(sqlSearch);
			ptst.setString(1, vo.getCpf());
			rs = ptst.executeQuery();
			if(rs.next()) {
				medico.setId(rs.getInt("ide"));
				medico.setNome(rs.getString("nome"));
				medico.setCpf(rs.getString("cpf"));
				medico.setIdade(rs.getInt("idade"));
				medico.setCrm(rs.getString("crm"));
				medico.setEspecialidade(rs.getString("especialidade"));
				medico.setGenero(rs.getString("genero"));
				medico.setLogin(rs.getString("login"));
				medico.setSenha(rs.getString("senha"));
			}else{
				System.out.println("Busca falhou, retornando nulo.");
				return null;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return medico;
	}
	
	public MedicoVO buscarNome(VO vo) throws SQLException {
		conn = getConnection();
		String sqlSearch = "select * from Medico where nome like ?";
		PreparedStatement ptst;
		ResultSet rs;
		MedicoVO medico = new MedicoVO();
		try {
			ptst = conn.prepareStatement(sqlSearch);
			ptst.setString(1, vo.getNome());
			rs = ptst.executeQuery();
			if(rs.next()) {
				medico.setId(rs.getInt("ide"));
				medico.setNome(rs.getString("nome"));
				medico.setCpf(rs.getString("cpf"));
				medico.setIdade(rs.getInt("idade"));
				medico.setGenero(rs.getString("genero"));
				medico.setCrm(rs.getString("CRM"));
				medico.setEspecialidade(rs.getString("especialidade"));
				medico.setLogin(rs.getString("login"));
				medico.setSenha(rs.getString("senha"));
			} else {
				System.out.println("Busca falhou, retornando nulo.");
				return null;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return medico;
	}
	
	public MedicoVO buscarID(MedicoVO vo) throws SQLException {
		conn = getConnection();
		String sqlSearch = "select * from Medico where ide = ?";
		PreparedStatement ptst;
		ResultSet rs;
		MedicoVO medico = new MedicoVO();
		try {
			ptst = conn.prepareStatement(sqlSearch);
			ptst.setInt(1, vo.getId());
			rs = ptst.executeQuery();
			if(rs.next()) {
				medico.setId(rs.getInt("ide"));
				medico.setNome(rs.getString("nome"));
				medico.setCpf(rs.getString("cpf"));
				medico.setIdade(rs.getInt("idade"));
				medico.setGenero(rs.getString("genero"));
				medico.setCrm(rs.getString("CRM"));
				medico.setEspecialidade(rs.getString("especialidade"));
				medico.setLogin(rs.getString("login"));
				medico.setSenha(rs.getString("senha"));
			} else {
				System.out.println("Busca falhou, retornando nulo.");
				return null;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return medico;
	}
	
	public ResultSet listar() {
		conn = getConnection();
		String sql = "select * from Medico";
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
	
	public ResultSet listarID(int id){
		conn = getConnection();
		String sql = "select * from Medico where ide = ?";
		PreparedStatement st;
		ResultSet rs;
		try {
			conn = getConnection();
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();
			return rs;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	/*public ArrayList<MedicoVO> listarCPF(VO vo) throws SQLException{
		String sql = "select * from Medico where cpf = " + vo.getCpf();
		Statement st;
		ResultSet rs;
		ArrayList<MedicoVO> medicos = new ArrayList<MedicoVO>();
		try {
			conn = getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			//List<MedicoVO> medicos = new ArrayList<MedicoVO>();
			//MedicoVO vo = new MedicoVO();
			
			while(rs.next()){
				MedicoVO c = new MedicoVO();
				c.setId(rs.getInt("ide_medico"));
				c.setCpf(rs.getString("cpf"));
				c.setNome(rs.getString("nome"));
				c.setIdade(rs.getInt("idade"));
				c.setGenero(rs.getString("genero"));
				c.setLogin(rs.getString("login"));
				c.setSenha(rs.getString("senha"));
				c.setCrm(rs.getString("crm"));
				c.setEspecialidade(rs.getString("especialidade"));
				medicos.add(c);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return medicos;
	}
	public ArrayList<MedicoVO> listarCRM(VO vo) throws SQLException{
		String sql = "select * from Medico where crm = " + vo.getCrm();
		Statement st;
		ResultSet rs;
		ArrayList<MedicoVO> medicos = new ArrayList<MedicoVO>();
		try {
			conn = getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			//List<MedicoVO> medicos = new ArrayList<MedicoVO>();
			//MedicoVO vo = new MedicoVO();
			
			while(rs.next()){
				MedicoVO c = new MedicoVO();
				c.setId(rs.getInt("ide_medico"));
				c.setCpf(rs.getString("cpf"));
				c.setNome(rs.getString("nome"));
				c.setIdade(rs.getInt("idade"));
				c.setGenero(rs.getString("genero"));
				c.setLogin(rs.getString("login"));
				c.setSenha(rs.getString("senha"));
				c.setCrm(rs.getString("crm"));
				c.setEspecialidade(rs.getString("especialidade"));
				medicos.add(c);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return medicos;
	}
	
	public ArrayList<MedicoVO> listarNome(VO vo) throws SQLException{
		String sql = "select * from Medico where nome = " + vo.getNome();
		Statement st;
		ResultSet rs;
		ArrayList<MedicoVO> medicos = new ArrayList<MedicoVO>();
		try {
			conn = getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			//List<MedicoVO> medicos = new ArrayList<MedicoVO>();
			//MedicoVO vo = new MedicoVO();
			
			while(rs.next()){
				MedicoVO c = new MedicoVO();
				c.setId(rs.getInt("ide_medico"));
				c.setCpf(rs.getString("cpf"));
				c.setNome(rs.getString("nome"));
				c.setIdade(rs.getInt("idade"));
				c.setGenero(rs.getString("genero"));
				c.setLogin(rs.getString("login"));
				c.setSenha(rs.getString("senha"));
				c.setCrm(rs.getString("crm"));
				c.setEspecialidade(rs.getString("especialidade"));
				medicos.add(c);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return medicos;
	}
	
	public ArrayList<MedicoVO> listarId(VO vo) throws SQLException{
		String sql = "select * from Medico where ide_medico = " + vo.getId();
		Statement st;
		ResultSet rs;
		ArrayList<MedicoVO> medicos = new ArrayList<MedicoVO>();
		try {
			conn = getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			//List<MedicoVO> medicos = new ArrayList<MedicoVO>();
			//MedicoVO vo = new MedicoVO();
			
			while(rs.next()){
				MedicoVO c = new MedicoVO();
				c.setId(rs.getInt("ide_medico"));
				c.setCpf(rs.getString("cpf"));
				c.setNome(rs.getString("nome"));
				c.setIdade(rs.getInt("idade"));
				c.setGenero(rs.getString("genero"));
				c.setLogin(rs.getString("login"));
				c.setSenha(rs.getString("senha"));
				c.setCrm(rs.getString("crm"));
				c.setEspecialidade(rs.getString("especialidade"));
				medicos.add(c);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return medicos;
	}*/
}
