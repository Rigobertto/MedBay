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
		String sql = "insert into Consulta (data, hora, id_exame, id_paciente, id_medico, observacao) values (?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			ps.setDate(1, new Date(vo.getData().getTimeInMillis())); //COMO FUNCIONA ISSO?????????????????????????????????????????????
			/*
				respondendo à pergunta:
				o método setDate, da classe PreparedStatement, recebe um inteiro, que é o índice da String sql e um objeto do tipo Date do pacote java.sql.
				o método getData da classe ConsultaVO retorna um Calendar do pacote java.util, que por meio do método getTimeInMillis() retorna o "Unix Timestamp" da data armazenada nele.
				o construtor de Data do pacote java.sql recebe um "Unix Timestamp" como parâmetro para construir o objeto.
				objeto esse que é adaptado para o "sql/banco de dados" e pode ser armazenado de forma correta.
			*/
			ps.setTime(2, new Time(vo.getData().getTimeInMillis()));
			ps.setInt(3, vo.getExame().getId());
			ps.setInt(4, vo.getPaciente().getId());
			ps.setInt(5, vo.getMedico().getId());
			ps.setString(6, vo.getObservacao());

			int affectedRolls = ps.executeUpdate();
			
			if(affectedRolls == 0) {
				System.out.println("Falha em cadastrar o usuário");
				return;
			}
			
			ResultSet chave = ps.getGeneratedKeys();
			if(chave.next()) {
				vo.setId(chave.getInt(1));
			}
			else {
				System.out.println("Falha ao obter Id de usuário cadastrado.");
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
}
