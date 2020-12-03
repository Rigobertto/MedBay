package projeto.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import projeto.model.vo.GerenteVO;
import projeto.model.vo.PacienteVO;

public class PacienteDAO<VO extends PacienteVO> extends PessoaDAO<VO> {
	
	public void cadastrar(VO vo) throws SQLException{
		conn = getConnection();
		String sql = "insert into Paciente(cpf, nome, idade, genero, altura, peso, sangue) values (?, ?, ?, ?, ?, ?, ?)";
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
		
		sql = "insert into Prontuario(cpf, nome, anotacao, data_anotacao) = values (?, ?, ?)";
		conn = getConnection();
		PreparedStatement ptsp = conn.prepareStatement(sql);
		try {
			ptsp.setString(1, vo.getCpf());
			ptsp.setString(2, vo.getNome());
			ptsp.setString(3, " ");
			ptsp.setCalendar(4, ""); // PQ NAO VAI????????????????
			ptsp.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void excluir(VO vo) throws SQLException{
		conn = getConnection();
		String sql = "delete from Paciente where ide_paciente = ?"; // revisar dps
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, vo.getId());
			ptst.executeUpdate(); //NOTA P/ Rigo: PELO AMOR DE DEUS LEMBRAR FAZER
		}catch(SQLException e) {	// A DELEÇÃO EM CASCATA PRA EXCLUIR O PRONTUÁRIO
			e.printStackTrace();
		}
	}
	public void editar(VO vo) throws SQLException{
		conn = getConnection();
		String sql = "update Paciente set nome = ?, idade = ?, genero = ?, altura = ?, peso = ?, sangue = ? where ide_paciente = ?"; // revisar dps
		PreparedStatement ptst = conn.prepareStatement(sql);
		try {
			//ptst.setString(1, vo.getCpf());
			ptst.setString(1, vo.getNome());
			ptst.setInt(2, vo.getIdade());
			ptst.setString(3, vo.getGenero());
			ptst.setFloat(4, vo.getAltura());
			ptst.setFloat(5, vo.getPeso());
			ptst.setString(6, vo.getTipoSangue());
			ptst.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		sql = "Update Prontuario set "
	}
	
	public ArrayList<PacienteVO> listar() throws SQLException{
		String sql = "select * from Paciente";
		Statement st;
		ResultSet rs;
		ArrayList<PacienteVO> pacientes = new ArrayList<PacienteVO>();
		try {
			conn = getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				PacienteVO vo = new PacienteVO();
				vo.setId(rs.getInt("ide_paciente")); // adicionar ID em PacienteVO
				vo.setCpf(rs.getString("cpf"));
				vo.setNome(rs.getString("nome"));
				vo.setIdade(rs.getInt("idade"));
				vo.setGenero(rs.getString("genero"));
				///////////////////////////////////////////////////////////////////////
				pacientes.add(vo);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return pacientes;
	}
	public ArrayList<VO> listarCPF(VO vo) throws SQLException{
		
	}
	public ArrayList<VO> listarNome(VO vo) throws SQLException{
		
	}
	public ArrayList<VO> listarID(VO vo) throws SQLException{
		
	}
	
}
