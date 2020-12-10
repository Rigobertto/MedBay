package medbay.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import medbay.model.bo.PacienteBO;
import medbay.model.vo.PacienteVO;
import medbay.view.Telas;

public class ListarPacienteController implements Initializable{
	@FXML private TableView<PacienteVO> tabelaPaciente;
    @FXML private TableColumn<PacienteVO, Integer> ide;
    @FXML private TableColumn<PacienteVO, String> nome;
	@FXML private TableColumn<PacienteVO, String> cpf;
	@FXML private TableColumn<PacienteVO, Integer> idade;
	@FXML private TableColumn<PacienteVO, String> genero;
	@FXML private TableColumn<PacienteVO, Float> altura;
	@FXML private TableColumn<PacienteVO, Float> peso;
	@FXML private TableColumn<PacienteVO, String> sangue;
	PacienteBO bo = new PacienteBO();
	
	public void initialize(URL url, ResourceBundle rb) {
    	listar();
    }
	
	public void listar(){ //AMADO??
		ObservableList<PacienteVO> pacientes = FXCollections.observableArrayList(bo.listar());
		ide.setCellValueFactory(new PropertyValueFactory<PacienteVO, Integer>("id"));
		nome.setCellValueFactory(new PropertyValueFactory<PacienteVO, String>("nome"));
		cpf.setCellValueFactory(new PropertyValueFactory<PacienteVO, String>("cpf"));
		idade.setCellValueFactory(new PropertyValueFactory<PacienteVO, Integer>("idade"));
		genero.setCellValueFactory(new PropertyValueFactory<PacienteVO, String>("genero"));
		altura.setCellValueFactory(new PropertyValueFactory<PacienteVO, Float>("altura"));
		peso.setCellValueFactory(new PropertyValueFactory<PacienteVO, Float>("peso"));
		sangue.setCellValueFactory(new PropertyValueFactory<PacienteVO, String>("sangue"));
		
		tabelaPaciente.setItems(pacientes);
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
			Telas.telaInicioGerente();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cadastrarPaciente(ActionEvent event) {
		try {
			Telas.telaCadastrarPaciente();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
