package medbay.model.bo;

import java.util.Calendar;
import java.util.List;

import medbay.model.util.CPF;
import medbay.model.vo.ConsultaVO;
import medbay.model.vo.MedicoVO;
import medbay.model.vo.PacienteVO;

public interface ConsultaInterBO {
    public boolean cadastrar(ConsultaVO consulta);

    public boolean editar(ConsultaVO consulta);

    public ConsultaVO buscarId(int id); // id da consulta
    public List<ConsultaVO> buscarNome(String nome); // nome do paciente e ou do médico
    public List<ConsultaVO> buscarCpf(CPF cpf); // cpf do paciente e ou do médico
    public List<ConsultaVO> buscarData(Calendar data); // "marcados em" e "marcados para"
    public List<ConsultaVO> buscarMedico(MedicoVO medico); // busca por id_medico
    public List<ConsultaVO> buscar(PacienteVO paciente); // busca por id_paciente
}