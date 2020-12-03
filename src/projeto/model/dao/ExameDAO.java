package projeto.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import projeto.model.vo.ExameVO;
import projeto.model.vo.GerenteVO;

public class ExameDAO<VO extends ExameVO> extends BaseDAO<VO> {
	public void cadastrar(VO vo) throws SQLException {
		conn = getConnection();
		String sql = "insert into Exame(nome, valor) values (?, ?)";
		PreparedStatement ptst = conn.prepareStatement(sql);
		try {
			ptst.setString(1, vo.getNome());
			ptst.setFloat(2, vo.getValor());
			ptst.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void excluir(VO vo) throws SQLException{
		conn = getConnection();
		String sql = "delete from Exame where ide_exame = ?"; // revisar dps
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, vo.getId());
			ptst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editar(VO vo) throws SQLException { // editar apenas nome e valor
		conn = getConnection();
		String sql = "update Exame set nome = ?, valor = ? where ide_exame = ?";
		PreparedStatement ptst = conn.prepareStatement(sql);
		try {
			ptst.setString(1, vo.getNome());
			ptst.setFloat(2, vo.getValor());
			ptst.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
	}

	public ArrayList<ExameVO> listar() throws SQLException{ // que erro???????
		String sql = "select * from Exame";
		Statement st;
		ResultSet rs;
		ArrayList<ExameVO> exames = new ArrayList<ExameVO>();
		try {
			conn = getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				ExameVO vo = new ExameVO();
				vo.setId(rs.getInt("ide_exame"));
				vo.setNome(rs.getString("nome"));
				vo.setValor(rs.getFloat("valor"));
				exames.add(vo);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return exames;
	}
	
	public ArrayList<ExameVO> listarID(VO vo) throws SQLException{
		String sql = "select * from Exame where ide_exame = " + vo.getId();
		Statement st;
		ResultSet rs;
		ArrayList<ExameVO> exames = new ArrayList<ExameVO>();
		try {
			conn = getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				ExameVO c = new ExameVO();
				c.setId(rs.getInt("ide_exame"));
				c.setNome(rs.getString("nome"));
				c.setValor(rs.getFloat("valor"));
				exames.add(c);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return exames;
	}
	
	public ArrayList<ExameVO> listarNome(VO vo) throws SQLException{
		String sql = "select * from Exame where nome = " + vo.getNome();
		Statement st;
		ResultSet rs;
		ArrayList<ExameVO> exames = new ArrayList<ExameVO>();
		try {
			conn = getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				ExameVO c = new ExameVO();
				c.setId(rs.getInt("ide_exame"));
				c.setNome(rs.getString("nome"));
				c.setValor(rs.getFloat("valor"));
				exames.add(c);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return exames;
	}
}
