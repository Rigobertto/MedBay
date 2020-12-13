package medbay.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import medbay.model.bo.PacienteBO;
import medbay.model.vo.PacienteVO;
import medbay.view.Telas;

public class EditarPacienteController implements Initializable{
	@FXML private Label cpf;
	@FXML private Label ide;
	@FXML private TextField editarNome;
	@FXML private TextField editarIdade;
	@FXML private TextField editarAltura;
	@FXML private TextField editarPeso;
	@FXML private TextField editarSangue;
	@FXML private Label lblMensagem;
	@FXML private ComboBox<String> editarGenero;
	private ObservableList<String> generoCategorias;
	private List<String> generos = new ArrayList<>();
	private static PacienteVO paciente = new PacienteVO();
	PacienteBO bo = new PacienteBO();
	
	public void initialize(URL url, ResourceBundle rb){
		carregarGenero();
		ide.setText(Integer.toString(paciente.getId()));
		cpf.setText(paciente.getCpf());
		//editarNome.setPromptText(user.getNome());
		//editarIdade.setPromptText(Integer.toString(user.getIdade()));
		//editarLogin.setPromptText(user.getLogin());
	}
	
	public void editar(ActionEvent event)throws Exception{
		try {
			PacienteVO paci = new PacienteVO();
			paci.setId(paciente.getId());
			paci.setCpf(paciente.getCpf());
			paci.setNome(editarNome.getText());
			paci.setIdade(Integer.parseInt(editarIdade.getText()));
			if(editarGenero.getValue() == "Masculino") {
				paci.setGenero("M");
			}else if(editarGenero.getValue() == "Feminino") {
				paci.setGenero("F");
			}else{
				paci.setGenero("O");
			}
			paci.setAltura(Float.parseFloat(editarAltura.getText()));
			paci.setPeso(Float.parseFloat(editarPeso.getText()));
			paci.setTipoSangue(editarSangue.getText());
			boolean valor = bo.editar(paci);
			if(valor == true)
				lblMensagem.setVisible(true);
			else {
				lblMensagem.setText("Erro ao editar Paciente!");
				lblMensagem.setVisible(true);
			}
		}catch(Exception e) {
			e.printStackTrace();
			lblMensagem.setText("Falha ao editar Paciente!");
			lblMensagem.setVisible(true);
		}
	}
	
	public void carregarGenero(){
		
		generos.add("Masculino");
		generos.add("Feminino");
		generos.add("Outro");
		generoCategorias = FXCollections.observableArrayList(generos);
		editarGenero.setItems(generoCategorias);
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
			Telas.telaEntrarPaciente();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static PacienteVO getPaciente() {
		return paciente;
	}

	public static void setPaciente(PacienteVO vo) {
		paciente = vo;
	}
}
