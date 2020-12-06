package medbay.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import medbay.model.vo.ProntuarioVO;
import medbay.model.vo.PacienteVO;
public class ProntuarioDAO<VO extends ProntuarioVO> extends BaseDAO<VO> {
	
	public void cadastrar(PacienteVO vo) throws SQLException {
		conn = getConnection();
		String sql = "insert into Prontuario (ide_prontuario, cpf, observacao) values (?, ?, ?)";
		PreparedStatement ptst = conn.prepareStatement(sql);
		try {
			ptst.setInt(1, vo.getId());
			ptst.setString(2, vo.getCpf());
			ptst.setString(3, " ");
			ptst.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	
	
	public void excluir(VO vo) throws SQLException {
		
	}
	
	public void editar(VO vo) throws SQLException {
		
	}
	
	public ResultSet listar() throws SQLException {
		
	}
	
	public ProntuarioVO buscarID(VO vo) throws SQLException{
		
	}
}
