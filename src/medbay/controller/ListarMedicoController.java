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
import medbay.model.bo.MedicoBO;
import medbay.model.vo.MedicoVO;
import medbay.view.Telas;

public class ListarMedicoController implements Initializable{
	@FXML private TableView<MedicoVO> tabelaMedico;
    @FXML private TableColumn<MedicoVO, Integer> ide;
    @FXML private TableColumn<MedicoVO, String> nome;
	@FXML private TableColumn<MedicoVO, String> cpf;
	@FXML private TableColumn<MedicoVO, Integer> idade;
	@FXML private TableColumn<MedicoVO, String> genero;
	@FXML private TableColumn<MedicoVO, String> login;
	@FXML private TableColumn<MedicoVO, String> senha;
	@FXML private TableColumn<MedicoVO, String> especialidade;
	@FXML private TableColumn<MedicoVO, String> crm;
	MedicoBO bo = new MedicoBO();
	
	public void initialize(URL url, ResourceBundle rb) {
    	listar();
    }
    
    public void listar(){ //AMADO??
		ObservableList<MedicoVO> medico = FXCollections.observableArrayList(bo.listar());
		ide.setCellValueFactory(new PropertyValueFactory<MedicoVO, Integer>("id"));
		nome.setCellValueFactory(new PropertyValueFactory<MedicoVO, String>("nome"));
		cpf.setCellValueFactory(new PropertyValueFactory<MedicoVO, String>("cpf"));
		idade.setCellValueFactory(new PropertyValueFactory<MedicoVO, Integer>("idade"));
		genero.setCellValueFactory(new PropertyValueFactory<MedicoVO, String>("genero"));
		login.setCellValueFactory(new PropertyValueFactory<MedicoVO, String>("login"));
		senha.setCellValueFactory(new PropertyValueFactory<MedicoVO, String>("senha"));
		especialidade.setCellValueFactory(new PropertyValueFactory<MedicoVO, String>("especialidade"));
		crm.setCellValueFactory(new PropertyValueFactory<MedicoVO, String>("crm"));
		tabelaMedico.setItems(medico);
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
			Telas.telaInicioGerente();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void entrarCadastrarAtendenteMedico(ActionEvent event) {
		try {
			Telas.telaCadastrarAtendenteMedico();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
