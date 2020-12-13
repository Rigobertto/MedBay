package medbay.model.vo;

import java.util.Calendar;

public class ConsultaVO {
	private int id;
    private Calendar data;

    private ExameVO exame;

    private PacienteVO paciente;
    private MedicoVO medico;

    private String observacao;


    public int getId() {
        return this.id;
    }
    public boolean setId(int id) {
        if(id < 0) return false;
        else this.id = id;
        return true;
    }

    public Calendar getData() {
        return this.data;
    }

    public boolean setData(Calendar data) {
        if(data.getTimeInMillis() < Calendar.getInstance().getTimeInMillis()) return false;
        this.data = data;
        return true;
    }
    
    public boolean setData(String data, String hora) {
        return this.setData(Calendar.getInstance());
    }

    public ExameVO getExame() {
        return this.exame;
    }
    public boolean setExame(ExameVO exame) {
        if(exame == null) return false;
        this.exame = exame;
        return true;
    }
    
    public PacienteVO getPaciente() {
		return paciente;
	}

	public void setPaciente(PacienteVO paciente) {
		this.paciente = paciente;
	}

	public MedicoVO getMedico() {
        return this.medico;
    }
    public boolean setMedico(MedicoVO medico) {
        if(medico == null) return false;
        this.medico = medico;
        return true;
    }

    public String getObservacao() {
        return new String(this.observacao);
    }
    public boolean setObservacao(String observacao) {
        if(observacao == null || observacao.isEmpty()) return false;
        this.observacao = observacao;
        return true;
    }
}
