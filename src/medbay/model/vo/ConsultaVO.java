package medbay.model.vo;

import medbay.model.util.Tempo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ConsultaVO {
	private int id;
    private Calendar data;
    private ExameVO exame;
    private PacienteVO paciente;
    private MedicoVO medico;
    private String observacao;
    private String dataString;
    private String horaString;
    
    
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
        if(data == null || data.getTimeInMillis() < Calendar.getInstance().getTimeInMillis()) 
        	return false;
        this.data = data;
        this.setHoraString();
        this.setDataString();
        
        return true;
    }
    
    public boolean setData(String data, String hora) {
        return setData(Tempo.toCalendar(data, hora));
    }
    
    
    public String getDataString() {
    	return this.dataString;
    }
    
    private void setDataString() {
    	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String dataFinal = formatter.format(data.getTime());
    	this.dataString = dataFinal;
    }
    
    public String getHoraString() {
    	
    	return this.horaString;
    }
    
    private void setHoraString() {
    	SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		String horaFinal = formatter.format(data.getTime());
    	this.horaString = horaFinal;
    	System.out.println("hora final:" +horaFinal);
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
