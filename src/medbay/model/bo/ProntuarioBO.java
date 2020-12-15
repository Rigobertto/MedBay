package medbay.model.bo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import medbay.model.dao.ProntuarioDAO;
import medbay.model.vo.ConsultaVO;
import medbay.model.vo.ExameVO;
import medbay.model.vo.MedicoVO;
import medbay.model.vo.PacienteVO;
import medbay.model.vo.ProntuarioVO;


public class ProntuarioBO implements ProntuarioInterBO {
	
	ProntuarioDAO<ProntuarioVO> dao = new ProntuarioDAO<ProntuarioVO> ();
    ExameBO<ExameVO> ebo = new ExameBO<ExameVO>();
    PacienteBO pbo = new PacienteBO();
    MedicoBO<MedicoVO> mbo = new MedicoBO<MedicoVO>();
    
    public boolean editar(ProntuarioVO prontuario) {
        try {
        	dao.editar(prontuario);
        	return true;
        }catch(Exception e) {
        	e.printStackTrace();
        	return false;

        }
    }

    public List<ProntuarioVO> listar(ConsultaVO vo){
    	List<ProntuarioVO> lista = new ArrayList<ProntuarioVO>();
		try {
			ResultSet tabela = dao.listar(vo);
			
			while(tabela.next()) {
				ProntuarioVO prontuario = new ProntuarioVO();
				prontuario.setId(tabela.getInt("ide"));
				
				Calendar data = Calendar.getInstance();				
				Date date = tabela.getDate("data_consulta");
				Time time = tabela.getTime("hora_consulta");
				data.set(date.getYear()+1900, date.getMonth(), date.getDate(), time.getHours(), time.getMinutes());
				
				prontuario.setData(data);
				prontuario.setExame(ebo.buscaId(tabela.getInt("ide_exame")));
				prontuario.setPaciente(pbo.buscaId(tabela.getInt("ide_paciente")));
				prontuario.setObservacao(tabela.getString("observacao"));
				lista.add(prontuario);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return lista;
    }
}