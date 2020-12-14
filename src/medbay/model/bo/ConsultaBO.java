package medbay.model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import medbay.model.dao.ConsultaDAO;
import medbay.model.vo.ConsultaVO;
import medbay.model.vo.ExameVO;
import medbay.model.vo.MedicoVO;

public class ConsultaBO /*implements ConsultaInterBO*/ {
	ConsultaDAO<ConsultaVO> dao = new ConsultaDAO<ConsultaVO>();
	
	ExameBO<ExameVO> ebo = new ExameBO<ExameVO>();
	PacienteBO pbo = new PacienteBO();
	MedicoBO<MedicoVO> mbo = new MedicoBO<MedicoVO>();
	
	public boolean cadastrar(ConsultaVO consulta) {
        try {
        	dao.cadastrar(consulta);
        	return true;
        }catch(Exception e){
        	e.printStackTrace();
        	return false;
        }
    }

    public boolean editar(ConsultaVO consulta) {
        try {
        	dao.editar(consulta);
        	return true;
        }
        catch(Exception e) {
        	e.printStackTrace();
        	return false;
        }
    }
	
	public void excluir(ConsultaVO consulta) {
        try {
        	dao.excluir(consulta);
        }catch(Exception e) {
        	e.printStackTrace();
        }
    }

	public List<ConsultaVO> listar() {
		List<ConsultaVO> lista = new ArrayList<ConsultaVO>();
		
		try {
			ResultSet tabela = dao.listar();
			
			while(tabela.next()) {
				ConsultaVO consulta = new ConsultaVO();
				
				consulta.setId(tabela.getInt("ide"));
				
				Calendar data = Calendar.getInstance();
				data.setTimeInMillis(tabela.getTime("data").getTime());
				consulta.setData(data);
				
				consulta.setExame(ebo.buscaId(tabela.getInt("id_exame")));
				consulta.setPaciente(pbo.buscaId(tabela.getInt("id_paciente")));
				consulta.setMedico(mbo.buscaId(tabela.getInt("id_medico")));
				
				consulta.setObservacao(tabela.getString("observacao"));
				
				lista.add(consulta);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public List<ConsultaVO> listarID(MedicoVO medico) {
		List<ConsultaVO> lista = listar();
		List<ConsultaVO> resultado = new ArrayList<ConsultaVO>();
		
		for(int index = 0; index < lista.size(); index++) {
			if(lista.get(index).getMedico().getId() == medico.getId()) resultado.add(lista.get(index));
		}
		
		return resultado;
	}
	
	public ConsultaVO buscarId(int id) {
		ConsultaVO consulta = new ConsultaVO();
		consulta.setId(id);
		
		ResultSet tabela = dao.buscaID(consulta);
		
		try {
			Calendar data = Calendar.getInstance();
			data.setTimeInMillis(tabela.getTime("data").getTime());
			consulta.setData(data);
			
			consulta.setExame(ebo.buscaId(tabela.getInt("id_exame")));
			consulta.setPaciente(pbo.buscaId(tabela.getInt("id_paciente")));
			consulta.setMedico(mbo.buscaId(tabela.getInt("id_medico")));
			
			consulta.setObservacao(tabela.getString("observacao"));
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return consulta;
	}
}
