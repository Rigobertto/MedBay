package medbay.model.dao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import medbay.model.vo.ConsultaVO;

public class ConsultaDAO<VO extends ConsultaVO> extends BaseDAO<VO>{
	
	public void cadastrar(ConsultaVO vo) {
		String sqlInsert = "insert into Consulta (ide_paciente, ide_exame, ide_medico, data_consulta, hora_consulta, observacao) values (?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ptst2;
		try {
			ptst2 = getConnection().prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
			ptst2.setInt(1, vo.getPaciente().getId());
			ptst2.setInt(2, vo.getExame().getId());
			ptst2.setInt(3, vo.getMedico().getId());
			ptst2.setDate(4, new Date(vo.getData().getTimeInMillis())); //COMO FUNCIONA ISSO?????????????????????????????????????????????
			ptst2.setDate(5, new Date(vo.getData().getTimeInMillis())); 
			/*
				respondendo à pergunta:
				o método setDate, da classe PreparedStatement, recebe um inteiro, que é o índice da String sql e um objeto do tipo Date do pacote java.sql.
				o método getData da classe ConsultaVO retorna um Calendar do pacote java.util, que por meio do método getTimeInMillis() retorna o "Unix Timestamp" da data armazenada nele.
				o construtor de Data do pacote java.sql recebe um "Unix Timestamp" como parâmetro para construir o objeto.
				objeto esse que é adaptado para o "sql/banco de dados" e pode ser armazenado de forma correta.
			*/
			
			/*MDS esse ome é bom viu
			 * 
			 */
			
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
				System.out.println("Falha ao obter Id de usuário cadastrado.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editar(ConsultaVO vo) {
		
	}

	public void excluir(ConsultaVO vo) {
	
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
