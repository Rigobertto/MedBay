package medbay.model.vo;

import java.util.Calendar;

public class ProntuarioVO {
	private int id;
	private Calendar data;

    private ExameVO exame;
    private MedicoVO medico;

    // private String laudo;
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
		if(data == null) return false;
		this.data = data;
		return true;
	}

	public ExameVO getExame() {
		return this.exame;
	}
	public boolean setExame(ExameVO exame) {
		if(exame == null) return false;
		this.exame = exame;
		return true;
	}

	public MedicoVO getMedico() {
		return this.medico;
	}
	public boolean setMedico(MedicoVO medico) {
		if(medico == null) return false;
		this.medico = medico;
		return true;
	}

	/*
	public String getLaudo() {
		return new String(this.laudo);
	}
	public boolean setLaudo(String texto) {
		if(texto == null || texto.isEmpty()) return false;
		this.observacao = texto.toUpperCase();
		return true;
	}
	*/

	public String getObservacao() {
		return new String(this.observacao);
	}
	public boolean setObservacao(String texto) {
		if(texto == null || texto.isEmpty()) return false;
		this.observacao = texto.toUpperCase();
		return true;
	}
}
