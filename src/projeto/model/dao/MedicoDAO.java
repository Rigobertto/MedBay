package projeto.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import projeto.model.vo.MedicoVO;

public class MedicoDAO<VO extends MedicoVO> extends UsuarioDAO <VO> {
	
	public void cadastrar(VO vo) throws SQLException {
		
		try {
			conn = getConnection();
			String sql = "insert into Medico(cpf, nome, idade, genero, login, senha, crm, especialidade) values (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ptst = conn.prepareStatement(sql);
			//ptst.setId()
			ptst.setString(1, vo.getCpf());
			ptst.setString(2, vo.getNome());
			ptst.setInt(3, vo.getIdade());
			ptst.setString(4, vo.getGenero());
			ptst.setString(5, vo.getLogin());
			ptst.setString(6, vo.getSenha());
			ptst.setString(7, vo.getCrm());
			ptst.setString(8, vo.getEspecialidade());
			// DUVIDA: Como fazer o vo.getcpf_gerente;
			ptst.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void excluir(VO vo) throws SQLException{
		conn = getConnection();
		String sql = "delete from Medico where ide_medico = ?"; // revisar dps
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
			//ptst.setString(1, vo.getCpf());
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
	
	public ArrayList<MedicoVO> listar() throws SQLException{
		String sql = "select * from Medico";
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
				MedicoVO vo = new MedicoVO();
				vo.setId(rs.getInt("ide_medico"));
				vo.setCpf(rs.getString("cpf"));
				vo.setNome(rs.getString("nome"));
				vo.setIdade(rs.getInt("idade"));
				vo.setGenero(rs.getString("genero"));
				vo.setLogin(rs.getString("login"));
				vo.setSenha(rs.getString("senha"));
				vo.setCrm(rs.getString("crm"));
				vo.setEspecialidade(rs.getString("especialidade"));
				medicos.add(vo);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return medicos;
	}
	
	public ArrayList<MedicoVO> listarCPF(VO vo) throws SQLException{
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
	}
}
