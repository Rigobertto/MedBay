package medbay.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
import medbay.model.vo.UsuarioVO;
public class UsuarioDAO <VO extends UsuarioVO> extends PessoaDAO<VO>{ // PRATICAMENTE FEITO MAS AINDA PRECISA FAZER VERIFICA��ES NO BANCO
	
	public UsuarioVO autenticar(UsuarioVO vo){
		conn = getConnection();
		ResultSet rs = null;
		String sql = "";
		PreparedStatement ptst;
		UsuarioVO user = new UsuarioVO();
		user.setTabela(0);
		try {
			if(user.getTabela() == 0) {
				sql = "select * from Gerente where login = " + vo.getLogin();
				ptst = conn.prepareStatement(sql);
				rs = ptst.executeQuery();
				if(rs.next()) {
					user.setId(rs.getInt("ide"));
					user.setNome(rs.getString("nome"));
					user.setCpf(rs.getString("cpf"));
					user.setIdade(rs.getInt("idade"));
					user.setGenero(rs.getString("genero"));
					user.setLogin(rs.getString("login"));
					user.setSenha(rs.getString("senha"));
					user.setTabela(1);
				}
			}
			if(user.getTabela() != 1) {
				sql = "select * from Atendente where login = " + vo.getLogin();
				ptst = conn.prepareStatement(sql);
				rs = ptst.executeQuery();
				if(rs.next()) {
					user.setId(rs.getInt("ide_atendente"));
					user.setNome(rs.getString("nome"));
					user.setCpf(rs.getString("cpf"));
					user.setIdade(rs.getInt("idade"));
					user.setGenero(rs.getString("genero"));
					user.setLogin(rs.getString("login"));
					user.setSenha(rs.getString("senha"));
					user.setTabela(2);
				}
			}
			if(user.getTabela() != 1 || user.getTabela() != 2){
				sql = "select * from Medico where login = " + vo.getLogin();
				ptst = conn.prepareStatement(sql);
				rs = ptst.executeQuery();
				if(rs.next()) {
					user.setId(rs.getInt("ide_medico"));
					user.setNome(rs.getString("nome"));
					user.setCpf(rs.getString("cpf"));
					user.setIdade(rs.getInt("idade"));
					user.setGenero(rs.getString("genero"));
					user.setLogin(rs.getString("login"));
					user.setSenha(rs.getString("senha"));
					user.setTabela(3);
				}
			}
		}catch(SQLException e){
			e.getStackTrace();
			return null;
		}
		return user;
	}
	
	public UsuarioVO autenticarSenha(UsuarioVO vo, String tabela) throws SQLException{
		
		conn = getConnection();
		String sqlSearch = "select * from " + tabela +" where senha = " + vo.getSenha();
		PreparedStatement ptst;
		ResultSet rs;
		UsuarioVO user = new UsuarioVO();
		try {
			ptst = conn.prepareStatement(sqlSearch);
			rs = ptst.executeQuery();
			if(rs.next()){
				user.setId(rs.getInt("ide")); // mudar para apenas IDE
				user.setNome(rs.getString("nome"));
				user.setCpf(rs.getString("cpf"));
				user.setIdade(rs.getInt("idade"));
				user.setGenero(rs.getString("genero"));
				user.setLogin(rs.getString("login"));
				user.setSenha(rs.getString("senha"));
			} else {
				System.out.println("Busca falhou, retornando nulo.");
				return null;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return user;
	}
	
	public  void cadastrar(VO vo) throws SQLException{
		
	}
	
	public void excluir(VO vo) throws SQLException{
		
	}
	
	public void editar(VO vo) throws SQLException{
		
	}
	
	public  ResultSet listar() throws SQLException{
		return  null ;
	}
	
	public ResultSet listarID(VO vo) throws SQLException{
		return  null ;
	}
	
	public ResultSet listarNome(VO vo) throws SQLException{
		return  null;
	}
	
	public ResultSet listarCPF(VO vo) throws SQLException{
		return  null;
	}
}
