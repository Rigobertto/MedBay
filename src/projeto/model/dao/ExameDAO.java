package projeto.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import projeto.model.vo.ExameVO;


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

	public ResultSet listar() throws SQLException{ // que erro???????
		conn = getConnection();
		String sql = "select * from Exame";
		Statement st;
		ResultSet rs = null;
		//ArrayList<ExameVO> exames = new ArrayList<ExameVO>();
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery(sql);
			
			/*while(rs.next()){
				ExameVO vo = new ExameVO();
				vo.setId(rs.getInt("ide_exame"));
				vo.setNome(rs.getString("nome"));
				vo.setValor(rs.getFloat("valor"));
				exames.add(vo);
			}*/
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
	
	public ExameVO buscarID(ExameVO vo) throws SQLException {
		conn = getConnection();
		String sqlSearch = "select * from Exame where ide_exame like ?";
		PreparedStatement ptst;
		ResultSet rs;
		ExameVO exame = new ExameVO();
		try {
			ptst = conn.prepareStatement(sqlSearch);
			ptst.setInt(1, vo.getId());
			rs = ptst.executeQuery();
			if(rs.next()) {
				exame.setId(rs.getInt("ide_exame"));
				exame.setNome(rs.getString("nome"));
				exame.setValor(rs.getFloat("valor"));
				
			} else {
				System.out.println("Busca falhou, retornando nulo.");
				return null;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return exame;
	}
	
	public ExameVO buscarNome(ExameVO vo) throws SQLException {
		conn = getConnection();
		String sqlSearch = "select * from Exame where nome like ?";
		PreparedStatement ptst;
		ResultSet rs;
		ExameVO exame = new ExameVO();
		try {
			ptst = conn.prepareStatement(sqlSearch);
			ptst.setString(1, vo.getNome());
			rs = ptst.executeQuery();
			if(rs.next()) {
				exame.setId(rs.getInt("ide_exame"));
				exame.setNome(rs.getString("nome"));
				exame.setValor(rs.getFloat("valor"));
				
			} else {
				System.out.println("Busca falhou, retornando nulo.");
				return null;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return exame;
	}
	
	public ResultSet listarID(VO vo) {
		return null;
	}
	
	/*public ArrayList<ExameVO> listarID(VO vo) throws SQLException{
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
	}*/
}
