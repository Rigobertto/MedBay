package medbay.model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import medbay.model.dao.ProntuarioDAO;
import medbay.model.vo.ConsultaVO;
import medbay.model.vo.ProntuarioVO;


public class ProntuarioBO implements ProntuarioInterBO {
	
	ProntuarioDAO<ProntuarioVO> daoProntuario = new ProntuarioDAO<ProntuarioVO> ();
    ExameBO boExa = new ExameBO();
    PacienteBO boPac = new PacienteBO();
    
    public boolean editar(ProntuarioVO prontuario) {
        try {
        	daoProntuario.editar(prontuario);
        	return true;
        }catch(Exception e) {
        	e.printStackTrace();
        	return false;

        }
    }

    public ArrayList<ProntuarioVO> listar(ConsultaVO consulta){
    	ArrayList<ProntuarioVO> prontuario = new ArrayList<ProntuarioVO>();
		try {
			ResultSet rs = daoProntuario.listar(consulta);
			while(rs.next()){
				ProntuarioVO vo = new ProntuarioVO();
				vo.setId(rs.getInt("ide"));
				vo.setPaciente(boPac.buscaId(rs.getInt("ide_paciente"))); 
				vo.setExame(boExa.buscaId(rs.getInt("ide_exame")));
				vo.setData(rs.getDate("data_consulta"));				//Como passo a data? e como transformo em string?
				vo.setObservacao(rs.getString("observacao"));
				prontuario.add(vo);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return prontuario;
    }
}