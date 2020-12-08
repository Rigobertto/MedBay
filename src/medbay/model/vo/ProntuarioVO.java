package medbay.model.vo;

import java.util.Calendar;

public class ProntuarioVO {
	private int id;
	private Calendar data;

    private int id_exame; // pode ser um objeto do tipo exame, facilitaria a vida do BO e Controller
    private int id_medico; // identificação do médico responsável, pode ser um objeto médico
    private int id_paciente; // identificação do paciente, pode ser um objeto do tipo paciente

    private String laudo; // resultado dos exames contendo o parecer do médico
    private String observacao; // observações que indicam algo feito no exame

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

	public int getExame() {
		return this.id_exame;
	}

	public boolean setExame(int id_exame) {
		if(id_exame <= 0x00) return false;
		this.id_exame = id_exame;
		return true;
	}

	public int getMedico() {
		return this.id_medico;
	}

	public boolean setMedico(int id_medico) {
		if(id_medico <= 0x00) return false;
		this.id_medico = id_medico;
		return true;
	}

	public int getPaciente() {
		return this.id_paciente;
	}

	public boolean setPaciente(int id_paciente) {
		if(id_paciente <= 0x00) return false;
		this.id_paciente = id_paciente;
		return true;
	}

	public String getLaudo() {
		return new String(this.laudo);
	}

	public boolean setLaudo(String texto) {
		if(texto == null || texto.isEmpty()) return false;
		this.observacao = texto.toUpperCase();
		return true;
	}

	public String getObservacao() {
		return new String(this.observacao);
	}

	public boolean setObservacao(String texto) {
		if(texto == null || texto.isEmpty()) return false;
		this.observacao = texto.toUpperCase();
		return true;
	}
}
