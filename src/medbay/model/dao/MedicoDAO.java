package medbay.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import medbay.model.vo.MedicoVO;

public class MedicoDAO<VO extends MedicoVO> extends UsuarioDAO <VO> {
	
	public void cadastrar(VO vo) throws SQLException {
		
		try {
			conn = getConnection();
			String sql = "insert into Medico(cpf, nome, idade, genero, login, senha, crm, especialidade) values (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ptst = conn.prepareStatement(sql);
			ptst.setString(1, vo.getCpf());
			ptst.setString(2, vo.getNome());
			ptst.setInt(3, vo.getIdade());
			ptst.setString(4, vo.getGenero());
			ptst.setString(5, vo.getLogin());
			ptst.setString(6, vo.getSenha());
			ptst.setString(7, vo.getCrm());
			ptst.setString(8, vo.getEspecialidade());
			ptst.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void excluir(VO vo) throws SQLException{
		conn = getConnection();
		String sql = "delete from Medico where ide_medico = ?";
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
		String sql = "update Medico set nome = ?, idade = ?, genero = ?, especialidade = ? where ide_medico = ?"; // revisar dps
		PreparedStatement ptst = conn.prepareStatement(sql);
		try {
			ptst.setString(1, vo.getNome());
			ptst.setInt(2, vo.getIdade());
			ptst.setString(3, vo.getGenero());
			ptst.setString(4, vo.getEspecialidade());
			ptst.setInt(5, vo.getId());
			ptst.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
	}
	
	public MedicoVO buscarCPF(MedicoVO vo) throws SQLException {
		conn = getConnection();
		String sqlSearch = "select * from Medico where cpf like ?";
		PreparedStatement ptst;
		ResultSet rs;
		MedicoVO medico = new MedicoVO();
		try {
			ptst = conn.prepareStatement(sqlSearch);
			ptst.setString(1, vo.getCpf());
			rs = ptst.executeQuery();
			if(rs.next()) {
				medico.setId(rs.getInt("ide_medico"));
				medico.setNome(rs.getString("nome"));
				medico.setCpf(rs.getString("cpf"));
				medico.setIdade(rs.getInt("idade"));
				medico.setCrm(rs.getString("CRM"));
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
				medico.setId(rs.getInt("ide_medico"));
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
		String sqlSearch = "select * from Medico where ide_medico like ?";
		PreparedStatement ptst;
		ResultSet rs;
		MedicoVO medico = new MedicoVO();
		try {
			ptst = conn.prepareStatement(sqlSearch);
			ptst.setInt(1, vo.getId());
			rs = ptst.executeQuery();
			if(rs.next()) {
				medico.setId(rs.getInt("ide_medico"));
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
	
	public ResultSet listar() throws SQLException{
		conn = getConnection();
		String sql = "select * from Medico";
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
