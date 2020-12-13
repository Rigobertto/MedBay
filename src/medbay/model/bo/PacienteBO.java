package medbay.model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import medbay.model.dao.PacienteDAO;
import medbay.model.vo.PacienteVO;

public class PacienteBO implements PacienteInterBO{
	PacienteDAO<PacienteVO> dao = new PacienteDAO<PacienteVO>();
	public boolean cadastrar(PacienteVO paciente) {
		try {
    		dao.cadastrar(paciente);
    		return true;
    	}catch(SQLException e) {
    		e.printStackTrace();
    		return false;
    	}
		
	}
	
	public List<PacienteVO> listar() {
		ArrayList<PacienteVO> pacientes = new ArrayList<PacienteVO>();
		try {
			ResultSet rs = dao.listar();
			while(rs.next()){
				PacienteVO vo = new PacienteVO();
				vo.setId(rs.getInt("ide"));
				vo.setNome(rs.getString("nome"));
				vo.setCpf(rs.getString("cpf"));
				vo.setIdade(rs.getInt("idade"));
				vo.setGenero(rs.getString("genero"));
				vo.setAltura(rs.getFloat("altura"));
				vo.setPeso(rs.getFloat("peso"));
				vo.setTipoSangue(rs.getString("sangue"));
				pacientes.add(vo);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return pacientes;
	}
	
	public boolean editar(PacienteVO paciente){
		try {
			dao.editar(paciente);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public void excluir(PacienteVO paciente){
		try {
			dao.excluir(paciente);
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}
	
	public PacienteVO buscaId(int id) {
		PacienteVO paciente = new PacienteVO();
		paciente.setId(id);
		
		ResultSet tabela = dao.buscaID(paciente);
		try {
			paciente.setNome(tabela.getString("nome"));
			paciente.setIdade(tabela.getInt("idade"));
			paciente.setCpf(tabela.getString("cpf"));
			paciente.setGenero(tabela.getString("genero"));
			paciente.setPeso(tabela.getFloat("peso"));
			paciente.setAltura(tabela.getFloat("Altura"));
			paciente.setTipoSangue(tabela.getString("sangue"));
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return paciente;
	}
//	
//	public PacienteVO buscaCPF(PacienteVO paciente){
//	//	Ir� receber uma String CPF para retornar o objeto do tipo Pessoa que tem como atributo igual a mesma String CPF
//	//	recebida por parametro e poder retornar.
//	//	Vale destacar que antes de ir para o m�todo de busca no DAO, a String recebida por parametro ir� passar por uma valida��o
//	//	para saber se � de fato um n�mero de CPF;
//	}
//	
//	public PacienteVO buscaNome(PacienteVO paciente){
//		//	Ir� receber uma String nome para retornar o objeto do tipo Pessoa que tem como atributo igual a mesma String nome
//		//	recebida por parametro e poder retornar a exibi��o dos atributos do objeto.
//		//	Vale destacar que antes de ir para o m�todo de busca no DAO, a String recebida por parametro ir� passar por uma valida��o
//		//	para saber se � de fato uma String nula e etc.
//	}
	
}
