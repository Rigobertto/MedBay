package projeto.model.vo;

import java.util.Calendar;

public class ConsultaVO {
	private int id;

    private Calendar data_cadastro; // data e hora de cadastro da consulta
    private Calendar data_consulta; // data e hora para qual foi marcada a consulta

    // private Medico medico;
    private ExameVO exame;

    private String observacao;

    public void Consulta() {
        setDataCadastro(Calendar.getInstance());
    }

    public int getId() {
        return this.id;
    }

    public boolean setId(int id) {
        if(id < 0) return false;
        else this.id = id;
        return true;
    }

    public Calendar getDataCadastro() {
        return this.data_cadastro;
    }

    private void setDataCadastro(Calendar data) {
        this.data_cadastro = data;
    }

    public Calendar getDataConsulta() {
        return this.data_consulta;
    }

    public boolean setDataConsulta(Calendar data) {
        if(data.getTimeInMillis() < this.data_cadastro.getTimeInMillis()) return false;
        this.data_consulta = data;
        return true;
    }

    public ExameVO getExame() {
        return this.exame;
    }

    public boolean setExame(ExameVO exame) {
        if(exame == null) return false;

        if(exame.getData().getTimeInMillis() < this.data_cadastro.getTimeInMillis()) return false;
        if(exame.getData().getTimeInMillis() < this.data_consulta.getTimeInMillis()) return false;

        this.exame = exame;
        return true;
    } 

    public boolean setObservacao(String observacao) {
        if(observacao == null || observacao.isEmpty()) return false;
        	this.observacao = observacao;
        return true;
    }

    public String getObservacao() {
        return new String(this.observacao);
    }
}
