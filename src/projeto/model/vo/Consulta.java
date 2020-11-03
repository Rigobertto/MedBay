package projeto.model.vo;

import java.util.Calendar;

public class Consulta {
    private int id;

    private Calendar data_cadastro; // data e hora de cadastro da consulta
    private Calendar data_consulta; // data e hora para qual foi marcada a consulta

    // private Medico medico;
    private Exame exame;

    private String observacao;

    public void Consulta() {
        setDataCadastro(Calendar.getInstance());
    }

    public int getId() {
        return this.id;
    }

    public boolean setId(int id_consulta) {
        if(id_consulta < 0) return false;
        else this.id = id_consulta;
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

    public Exame getExame() {
        return this.exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    } 

    public void setObservacao(String observacao) {
        if(observacao != null) this.observacao = observacao;
    }

    public String getObservacao() {
        return this.observacao;
    }
}