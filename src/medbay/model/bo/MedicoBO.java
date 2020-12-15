package medbay.model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import medbay.model.dao.MedicoDAO;
import medbay.model.util.Texto;
import medbay.model.vo.MedicoVO;

public class MedicoBO<VO extends MedicoVO> implements MedicoInterBO{
	MedicoDAO<MedicoVO> dao = new MedicoDAO<MedicoVO>();
	
		public boolean cadastrar(MedicoVO medico) {
			try {
	    		dao.cadastrar(medico);
	    		return true;
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    		return false;
	    	}
			
		}
		
		public ArrayList<MedicoVO> listar() {
			ArrayList<MedicoVO> medicos = new ArrayList<MedicoVO>();
			try {
				ResultSet rs = dao.listar();
				while(rs.next()){
					MedicoVO vo = new MedicoVO();
					vo.setId(rs.getInt("ide"));
					vo.setNome(rs.getString("nome"));
					vo.setCpf(rs.getString("cpf"));
					vo.setIdade(rs.getInt("idade"));
					vo.setGenero(rs.getString("genero"));
					vo.setLogin(rs.getString("login"));
					vo.setSenha(rs.getString("senha"));
					vo.setEspecialidade(rs.getString("especialidade"));
					vo.setCrm(rs.getString("crm"));
					medicos.add(vo);
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
			return medicos;
		}
		
		public List<MedicoVO> listarNome(String nome) {
			List<MedicoVO> lista = this.listar();
			List<MedicoVO> resultado = new ArrayList<MedicoVO>();
			
			for(int index = 0; index < lista.size(); index++) {
				if(Texto.contem(lista.get(index).getNome(), nome)) resultado.add(lista.get(index));
			}
			
			return resultado;
		}
		
		
		
		public void excluir(MedicoVO medico){
			try {
				dao.excluir(medico);
				
			}catch(Exception e) {
				e.printStackTrace();
				
			}
		}
		
		public boolean editar(MedicoVO medico) {
			try {
				dao.editar(medico);
				return true;
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		}

		public MedicoVO buscaId(int id) {
			MedicoVO medico = new MedicoVO();
			medico.setId(id);
			try {
				medico = dao.buscarID(medico);
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
			return medico;
		}
		
		public MedicoVO listarID(int id) {
			try {
				MedicoVO vo = new MedicoVO();
				ResultSet rs = dao.listarID(id);
				if(rs.next()){
					vo.setId(rs.getInt("ide"));
					vo.setNome(rs.getString("nome"));
					vo.setCpf(rs.getString("cpf"));
					vo.setIdade(rs.getInt("idade"));
					vo.setGenero(rs.getString("genero"));
					vo.setLogin(rs.getString("login"));
					vo.setSenha(rs.getString("senha"));
					vo.setEspecialidade(rs.getString("especialidade"));
					vo.setCrm(rs.getString("crm"));
				}
				return vo;
			}catch(SQLException e){
				e.printStackTrace();
				return null;
			}
		}
	
}
