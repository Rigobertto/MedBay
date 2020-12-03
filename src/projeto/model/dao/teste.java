package projeto.model.dao;

import java.sql.SQLException;

import projeto.model.vo.GerenteVO;
import projeto.model.vo.MedicoVO;
import projeto.model.vo.UsuarioVO;

public class teste {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//BaseDAO dao = new BaseDAO();
		//System.out.println(dao.getConnection());
		GerenteDAO<GerenteVO> dao = new GerenteDAO<GerenteVO>();
		//UsuarioVO vo = new UsuarioVO();
		GerenteVO vo = new GerenteVO();
		vo.setCpf("05772418343");
		vo.setIdade(25);
		vo.setNome("Alyson Iury");
		vo.setGenero("M");
		vo.setLogin("talkei");
		vo.setSenha("PiorMat");
		dao.cadastrar(vo);
	}

}
