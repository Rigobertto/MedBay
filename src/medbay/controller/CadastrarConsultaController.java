package medbay.controller;

import java.net.URL;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

//import controller.TextFieldFormatter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import medbay.model.bo.ConsultaBO;
import medbay.model.bo.ExameBO;
import medbay.model.bo.MedicoBO;
import medbay.model.vo.ConsultaVO;
import medbay.model.vo.ExameVO;
import medbay.model.vo.MedicoVO;
import medbay.model.vo.PacienteVO;
import medbay.view.Telas;

public class CadastrarConsultaController implements Initializable{
	@FXML private Label lblMensagem;
	@FXML private Label nome;
	@FXML private Label cpf;
	@FXML private TextArea obs;
	@FXML private ComboBox<String> nomeExame;
	@FXML private ComboBox<String> nomeMedico;
	@FXML private TextField hora_consulta;
	@FXML private DatePicker horaConsulta;
	String data;
	
	
	ExameBO<ExameVO> boExa = new ExameBO<ExameVO>();
	MedicoBO<MedicoVO> boMed = new MedicoBO<MedicoVO>();
	ConsultaBO boConsulta = new ConsultaBO();
	ConsultaVO consulta = new ConsultaVO();

	private static PacienteVO paciente = new PacienteVO(); 

	public void initialize(URL url, ResourceBundle rb) {
		nome.setText(paciente.getNome());
		cpf.setText(paciente.getCpf());
		carregarExame();
		carregarMedico();
	}
	
	public void cadastrar(ActionEvent event){
		try {
			Calendar data_consulta = Calendar.getInstance();
			data_consulta.setTime(Date.from(Instant.from(horaConsulta.getValue().atStartOfDay(ZoneId.systemDefault()))));
			
			String exameAtual = nomeExame.getSelectionModel().getSelectedItem();
			String[] ide_exame = exameAtual.split("/");
			System.out.println(ide_exame[0]);
			ExameVO exame = new ExameVO();
			exame = boExa.listarID(Integer.parseInt(ide_exame[0]));
			
			String medicoAtual = nomeMedico.getSelectionModel().getSelectedItem();
			String[] ide_medico = medicoAtual.split("/");
			System.out.println(ide_medico[0]);
			MedicoVO medico;
			medico = boMed.listarID(Integer.parseInt(ide_medico[0]));
			
			consulta.setPaciente(paciente);
			consulta.setMedico(medico);
			consulta.setExame(exame);
			consulta.setData(data_consulta);
			consulta.setHora(hora_consulta.getText());	//Data ##/##/####
			consulta.setObservacao(obs.getText());
			boolean valor = boConsulta.cadastrar(consulta);
			if(valor == true){
				lblMensagem.setVisible(true);
			}else {
				lblMensagem.setText("Erro ao cadastrar!");
				lblMensagem.setVisible(true);
				}
		}catch(Exception e) {
			e.printStackTrace();
			lblMensagem.setText("Erro ao cadastrar!");
			lblMensagem.setVisible(true);
		}
		
	}

	public void carregarExame(){
		
		if (nomeExame != null) {
			
			ArrayList<ExameVO> aux2 = boExa.listar();
			ArrayList<String> aux3 = new ArrayList<String>();

			for (int i = 0; i < aux2.size(); i++) {
				aux3.add(aux2.get(i).getId() + "/" +aux2.get(i).getNome());
			}
			
			ObservableList<String> exames = FXCollections.observableArrayList(aux3);
			nomeExame.setItems(exames); 
		}
	}
	
	public void carregarMedico(){
		try {
			if (nomeMedico != null) {
				ArrayList<MedicoVO> aux2 = boMed.listar();
				ArrayList<String> aux3 = new ArrayList<String>();
	
				for (int i = 0; i < aux2.size(); i++) {
					aux3.add(aux2.get(i).getId() + "/" + aux2.get(i).getNome());
				}
	
				ObservableList<String> medicos = FXCollections.observableArrayList(aux3);
				nomeMedico.setItems(medicos);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void logOut(ActionEvent event) {
		try {
			Telas.telaLogin();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void voltar(ActionEvent event) {
		try {
			//fazer um if pra voltar para a tela certa
			Telas.telaEntrarPaciente();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void formatoHora() {
		TextFieldFormatter tex = new TextFieldFormatter();
		tex.setMask("##:##");
		tex.setCaracteresValidos("0123456789");
		tex.setTf(hora_consulta);
		tex.formatter();
	}
	
	public static PacienteVO getPaciente() {
		return paciente;
	}

	public static void setPaciente(PacienteVO paci) {
		paciente = paci;
	}
}
