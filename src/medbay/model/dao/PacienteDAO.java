package medbay.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import medbay.model.vo.PacienteVO;


public class PacienteDAO<VO extends PacienteVO> extends PessoaDAO<VO> {
	
	public void cadastrar(VO vo) throws SQLException{
		String sqlVerificarCPF = "select cpf from Gerente union select cpf from Atendente union "
				+ "select cpf from Medico union select cpf from Paciente";
		PreparedStatement ptst;
		ResultSet rs;
		String cpf = vo.getCpf();
		try {
			ptst = getConnection().prepareStatement(sqlVerificarCPF);
			rs = ptst.executeQuery();
			while(rs.next()) {
				if(cpf.equals(rs.getString("cpf"))){ //para caso o login já exista
					System.out.println("O CPF já existe, insira um novo!");
					return;
				}
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		
		String sqlInsert = "insert into Paciente(nome, cpf, idade, genero, altura, "
				+ "peso, sangue) values (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ptst2;
		try {
			ptst2 = getConnection().prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
			ptst2.setString(1, vo.getNome());
			ptst2.setString(2, vo.getCpf());
			ptst2.setInt(3, vo.getIdade());
			ptst2.setString(4, vo.getGenero());
			ptst2.setFloat(5, vo.getAltura());
			ptst2.setFloat(6, vo.getPeso());
			ptst2.setString(7, vo.getTipoSangue());
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
			//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA KRL PORRA
	}
	
	public void excluir(VO vo) throws SQLException{ //invocar excluir do pronturaio tbm
		conn = getConnection();
		String sql = "delete from Paciente where ide = ?"; // revisar dps
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, vo.getId());
			ptst.executeUpdate(); //NOTA P/ Rigo: PELO AMOR DE DEUS LEMBRAR DE FAZER
		}catch(SQLException e) {	// A DELEï¿½ï¿½O EM CASCATA PRA EXCLUIR O PRONTUï¿½RIO
			e.printStackTrace();
		}
	}
	public void editar(VO vo) throws SQLException{
		conn = getConnection();
		String sql = "update Paciente set nome = ?, idade = ?, genero = ?, altura = ?, peso = ?, sangue = ? where ide = ?"; // revisar dps
		PreparedStatement ptst = conn.prepareStatement(sql);
		try {
			ptst.setString(1, vo.getNome());
			ptst.setInt(2, vo.getIdade());
			ptst.setString(3, vo.getGenero());
			ptst.setFloat(4, vo.getAltura());
			ptst.setFloat(5, vo.getPeso());
			ptst.setString(6, vo.getTipoSangue());
			ptst.setInt(7, vo.getId());
			ptst.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
//		sql = "Update Prontuario set cpf = ?, nome = ?, where ide_paciente = ?"; //
//		try {
//			ptst.setString(1, vo.getNome());
//			ptst.setInt(2, vo.getIdade());
//			ptst.setString(3, vo.getGenero());
//			ptst.setFloat(4, vo.getAltura());
//			ptst.setFloat(5, vo.getPeso());
//			ptst.setString(6, vo.getTipoSangue());
//			ptst.executeUpdate();
//			}catch(SQLException e) {
//				e.printStackTrace();
//			}
	}
	
	public ResultSet listar() throws SQLException{
		conn = getConnection();
		String sql = "select * from Paciente";
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
	
	public ResultSet listarCPF(VO vo) throws SQLException{
		return null;
	}
	public ResultSet listarNome(VO vo) throws SQLException{
		return null;
	}
	public ResultSet listarID(VO vo) throws SQLException{
		return null;
	}
	
}
