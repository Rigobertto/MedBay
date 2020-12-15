package medbay.model.vo;

import medbay.model.util.Tempo;

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
        return setData(Tempo.toCalendar(data, hora));
    }
    
    public String dataString() {
    	return Tempo.dataToString(this.data);
    }
    
    public String horaString() {
    	return Tempo.horaToString(this.data);
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
	
	/*
    public String getData(Calendar data) {
		return Util.formataData(data);
	}
	
	public Calendar getData() {
		return data;
	}
	
	public void setData() {
		data = Calendar.getInstance();
	}
	
	public void setData(Calendar data) {
		if(data != null)
			this.data = data;
		else
			System.out.println("Data Inv�lida!");
	}
	
	public void setData(String d) {
		if (d != null && !d.isEmpty()) {
			Calendar data = Util.formataData(d);
			if(data != null)		
				this.data = data;
			else System.out.println("Data inv�lida!");
		} else System.out.println("Data inv�lida!");
	}
	
	public String getHora(Calendar hora) {
		return Util.formataHora(hora);
	}
	
	public Calendar getHora() {
		return hora;
	}
	
	public void setHora() {
		hora = Calendar.getInstance();
	}
	
	public void setHora(Calendar hora) {
		if(hora != null)
			this.hora = hora;
		else
			System.out.println("Hora Inv�lida!");
	}
	
	public void setHora(String h) {
		if (h!= null && !h.isEmpty()) {
			Calendar hora = Util.formataHora(h);
			if(hora != null)		
				this.hora = hora;
			else System.out.println("Hora inv�lida!");
		} else System.out.println("Hora inv�lida!");
	}
	*/
}
