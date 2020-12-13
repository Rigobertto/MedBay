package medbay.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

//import controller.TextFieldFormatter;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import medbay.model.bo.ExameBO;
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
	@FXML private ComboBox<String> listarExame;
	@FXML private ComboBox<MedicoVO> listarMedico;
	@FXML private TextField data_consulta;
	@FXML private TextField hora_consulta;
	private TextField text;
	String data;
	
	ExameBO<ExameVO> aux = new ExameBO<ExameVO>();
	ExameBO bo = new ExameBO();
	MedicoVO boMed = new MedicoVO();
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
			MedicoVO medico;
			ExameVO exame;
			medico = (listarMedico.getSelectionModel().getSelectedItem()); // Pesquisar ID selecionado dentro do comboBOX
			String exameAtual = listarExame.getSelectionModel().getSelectedItem();
			int id;
			{
				String ID = "";
				int indice = 0;
				for(indice = 0; exameAtual.charAt(indice) != '/'; indice++ );
					ID = exameAtual.substring(0, --indice);
					id = Integer.parseInt(ID);
			}
			exame = bo.buscaID(id);
			
			
			//exame = (); 
			consulta.setPaciente(paciente);
			consulta.setMedico(medico);
			consulta.setExame(exame);
			consulta.setData(data_consulta.getText(), hora_consulta.getText());	//Data ##/##/####
			consulta.setObservacao(obs.getText());
			lblMensagem.setVisible(true);
		}catch(Exception e) {
			e.printStackTrace();
			lblMensagem.setText("Erro ao cadastrar, verifique as informações!");
			lblMensagem.setVisible(true);
		}
		
	}

	public void carregarExame(){
	
		if (listarExame != null) {
			
			ArrayList<ExameVO> aux2 = aux.listar();
			ArrayList<String> aux3 = new ArrayList<String>();

			for (int i = 0; i < aux2.size(); i++) {
				aux3.add(aux2.get(i).getId() + "/" + aux2.get(i).getNome());
			}

			List<String> exames = FXCollections.observableArrayList(aux3);
			listarExame.setItems(exames); // implementar dps
		}
	}
	
	public void carregarMedico(){
		
		if (listarExame != null) {
			List<MedicoVO> aux2 = boMed.listar<MedicoVO>();
			ArrayList<String> aux3 = new ArrayList<String>();

			for (int i = 0; i < aux2.size(); i++) {
				aux3.add(aux2.get(i).getId() + "/" + aux2.get(i).getNome());
			}

			ObservableList<String> medicos = FXCollections.observableArrayList(aux3);
			listarExame.setItems(medicos);
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
			Telas.telaEntrarConsulta();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void formatoData() {
		TextFieldFormatter tex = new TextFieldFormatter();
		tex.setMask("##/##/####");
		tex.setCaracteresValidos("0123456789");
		tex.setTf(data_consulta);
		tex.formatter();
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

	public static void setPaciente(PacienteVO paciente) {
		CadastrarConsultaController.paciente = paciente;
	}
}
