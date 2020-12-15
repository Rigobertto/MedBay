package medbay.model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import medbay.model.dao.PacienteDAO;
import medbay.model.util.Texto;
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
	
	public List<PacienteVO> listarNome(String nome) {
		List<PacienteVO> lista = this.listar();
		List<PacienteVO> resultado = new ArrayList<PacienteVO>();
		
		for(int index = 0; index < lista.size(); index++) {
			if(Texto.contem(lista.get(index).getNome(), nome)) resultado.add(lista.get(index));
		}
		
		return resultado;
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
			if(tabela.next()) {
			paciente.setNome(tabela.getString("nome"));
			paciente.setIdade(tabela.getInt("idade"));
			paciente.setCpf(tabela.getString("cpf"));
			paciente.setGenero(tabela.getString("genero"));
			paciente.setPeso(tabela.getFloat("peso"));
			paciente.setAltura(tabela.getFloat("Altura"));
			paciente.setTipoSangue(tabela.getString("sangue"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return paciente;
	}
	
}
