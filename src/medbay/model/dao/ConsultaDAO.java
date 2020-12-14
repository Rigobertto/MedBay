package medbay.model.dao;
import java.sql.Date;
import java.sql.Time;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import medbay.model.vo.ConsultaVO;

public class ConsultaDAO<VO extends ConsultaVO> extends BaseDAO<VO>{
	
	public void cadastrar(ConsultaVO vo) {
		conn = getConnection();
		String sqlInsert = "insert into Consulta (data_consulta, hora_consulta, ide_exame, "
				+ "ide_paciente, ide_medico, observacao) values (?, ?, ?, ?, ?, ?)";
		PreparedStatement ptst2;
		try {
			ptst2 = getConnection().prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
			ptst2.setDate(1, new Date(vo.getData().getTimeInMillis()));
			ptst2.setTime(2, new Time(vo.getHora().getTimeInMillis()));
			ptst2.setInt(3, vo.getExame().getId());
			ptst2.setInt(4, vo.getPaciente().getId());
			ptst2.setInt(5, vo.getMedico().getId());
			ptst2.setString(6, vo.getObservacao());

			int affectedRolls = ptst2.executeUpdate();
			if(affectedRolls == 0) {
				System.out.println("Falha em cadastrar o usuário");
				return;
			}
			
			ResultSet chave = ptst2.getGeneratedKeys();
			if(chave.next()) {
				vo.setId(chave.getInt(1));
			} else {
				System.out.println("Falha ao obter Id de Consulta cadastrado.");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editar(ConsultaVO vo) {		
		conn = getConnection();
		String sql = "update Consulta set data = ?, id_exame = ?, id_paciente = ?, id_medico = ?, observacao = ? where ide = ?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setDate(1, new Date(vo.getData().getTimeInMillis()));
			ps.setInt(2, vo.getExame().getId());
			ps.setInt(3, vo.getPaciente().getId());
			ps.setInt(4, vo.getMedico().getId());
			ps.setString(5, vo.getObservacao());
			ps.setInt(6, vo.getId());
			ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluir(ConsultaVO vo) {
		conn = getConnection();
		String sql = "delete from Exame where ide = ?";
		
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, vo.getId());
			ptst.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet listar() throws SQLException{
		conn = getConnection();
		String sql = "select * from Consulta";
		PreparedStatement ptst;
		ResultSet rs = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			rs = ptst.executeQuery();
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet buscaID(VO vo) {
		conn = getConnection();
		String sql = "Select * from Consulta where ide = ?";
		
		PreparedStatement ps;
		ResultSet tabela = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vo.getId());
			tabela = ps.executeQuery();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return tabela;
	}
	
	public ResultSet buscarData(ConsultaVO consulta) {
		conn = getConnection();
		String sql = "select * from consulta where data_consulta = ?";
		PreparedStatement ptst;
		ResultSet rs;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setDate(1, new Date(consulta.getData().getTimeInMillis()));
			rs = ptst.executeQuery();
			return rs;
			
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
