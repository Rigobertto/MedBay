package medbay.model.dao;

import java.sql.SQLException;
import java.util.List;

import medbay.model.vo.GerenteVO;
import medbay.model.vo.MedicoVO;
import medbay.model.vo.UsuarioVO;

public class teste {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//BaseDAO dao = new BaseDAO();
		//System.out.println(dao.getConnection());
		GerenteDAO<GerenteVO> dao = new GerenteDAO<GerenteVO>();
		//UsuarioVO vo = new UsuarioVO();
		GerenteVO vo = new GerenteVO();
		vo.setNome("BRUNO CANTOR");
		List<GerenteVO> ger = dao.buscarNome(vo);
		
	}

}
