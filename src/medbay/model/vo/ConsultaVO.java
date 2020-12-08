package medbay.model.vo;

import java.util.Calendar;

public class ConsultaVO {
	private int id;

    private Calendar data; // a data para quando foi marcada a consulta

    private int id_paciente; // id do paciente no banco
    private int id_medico; // id do médico no banco

    private ProntuarioVO prontuario; // prontuario gerado no ato da consulta
    private String observacao; // resultado da consulta, observações médicas

    /*
    prontuario e observação marcam uma etapa de validação
    caso a observação seja null a consulta ainda não foi executada
    logo estará em aberto

    caso a observação seja diferente de null e não exista prontuario
    quer dizer que foi feita uma consulta e não houve a necessidade de
    fazer um exame

    caso exista observação e prontuario quer dizer que a a consulta foi feita
    e que os exames foram solicitados

    caso o prontuario conste uma observação igual a null indica que o exame não foi feito

    caso o prontuario tenha observação e não tenha laudo temos que o exame foi feito mas
    ainda não foi avaliado pelo médico

    caso o laudo exista no prontuario teremos uma consulta completamente concluida
    */

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

    public int getExame() {
        return this.id_exame;
    }

    public boolean setExame(int id_exame) {
        if(id_exame < 0x00) return false; // id 0x00 indica que não existe cadastro.
        this.id_exame = id_exame;
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

    public int getMedico() {
        return this.id_medico;
    }

    public boolean setMedico(int id_medico) {
        if(id_medico <= 0x00) return false;
        this.id_medico = id_medico;
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
