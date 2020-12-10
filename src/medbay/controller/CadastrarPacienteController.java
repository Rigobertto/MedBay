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

public class CadastrarPacienteController implements Initializable{
	@FXML private TextField nome;
	@FXML private TextField cpf;
	@FXML private TextField idade;
	@FXML private TextField sangue;
	@FXML private TextField altura;
	@FXML private TextField peso;
	@FXML private Label lblMensagem;
	@FXML private ComboBox<String> genero;
	private ObservableList<String> generoCategorias;
	private List<String> generos = new ArrayList<>();
	PacienteBO bo = new PacienteBO();
	
	public void cadastrar(ActionEvent event)throws Exception{
		try {
			PacienteVO paciente = new PacienteVO();
			paciente.setNome(nome.getText());
			paciente.setCpf(cpf.getText());
			paciente.setIdade(Integer.parseInt(idade.getText()));
			if(genero.getValue() == "Masculino") {
				paciente.setGenero("M");
			}else if(genero.getValue() == "Feminino") {
				paciente.setGenero("F");
			}else{
				paciente.setGenero("O");
			}
			paciente.setTipoSangue(sangue.getText());
			paciente.setAltura(Float.parseFloat(altura.getText()));
			paciente.setPeso(Float.parseFloat(peso.getText()));
			boolean valor = bo.cadastrar(paciente);
			if(valor == true)
				lblMensagem.setVisible(true);
			else {
				lblMensagem.setText("Erro ao cadastrar!");
				lblMensagem.setVisible(true);
			}
		}catch(Exception e) {
			e.printStackTrace();
			lblMensagem.setText("Falha ao Cadastrar Paciente!");
			lblMensagem.setVisible(true);
		}
	}
	
	public void initialize(URL url, ResourceBundle rb){
		carregarGenero();
	}
	public void carregarGenero(){
	
		generos.add("Masculino");
		generos.add("Feminino");
		generos.add("Outro");
		generoCategorias = FXCollections.observableArrayList(generos);
		genero.setItems(generoCategorias);
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
	
}
