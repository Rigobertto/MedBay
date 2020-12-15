package medbay.model.dao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import medbay.model.vo.ProntuarioVO;
import medbay.model.vo.ConsultaVO;

public class ProntuarioDAO<VO extends ProntuarioVO> extends BaseDAO<VO> {
	
	
	public void cadastrar(ConsultaVO vo) throws SQLException {
		conn = getConnection();
		String sql = "insert into Prontuario (ide_paciente, ide_exame, observacao, data_consulta, hora_consulta) values (?, ?, ?, ?, ?)";
		PreparedStatement ptst = conn.prepareStatement(sql);
		try {
			ptst.setInt(1, vo.getPaciente().getId());
			ptst.setInt(2, vo.getExame().getId());
			ptst.setString(3, " ");
			ptst.setDate(4, new Date(vo.getData().getTimeInMillis())); // COMO FAZ ISSO??????????????????
			ptst.setTime(5, new Time(vo.getData().getTimeInMillis()));
			ptst.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void excluir(ProntuarioVO vo) throws SQLException {
		conn = getConnection();
		String sql = "delete from Prontuario where ide = ?"; // revisar dps
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, vo.getId());
			ptst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editar(ProntuarioVO vo) throws SQLException {
		conn = getConnection();
		String sql = "update Prontuario set observacao = ? where ide = ?"; ///PELO AMOR DE DEUS QUE O MERGE NAO MUDE MAIS ESSA STRING AAAAAAAAAA
		PreparedStatement ptst = conn.prepareStatement(sql);
		try {
			ptst.setString(1, vo.getObservacao());
			ptst.setInt(2, vo.getId());
			ptst.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
	}
	
	public ResultSet listar(ConsultaVO vo) throws SQLException {
		String sql = "Select * from prontuario where ide_paciente = ?";
		PreparedStatement st;
		ResultSet rs = null;
		try {
			st = getConnection().prepareStatement(sql);
			st.setInt(1, vo.getPaciente().getId());
			rs = st.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet listar() {
		return null;
	}
	
	public void cadastrar(VO vo) {
		
	}
}
