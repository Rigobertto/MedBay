package medbay.model.dao;

import java.sql.SQLException;

import medbay.model.vo.ConsultaVO;

public interface ProntuarioInterDAO {
	
	public void cadastrar(ConsultaVO vo) throws SQLException;
}
