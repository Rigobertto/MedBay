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
import medbay.model.bo.AtendenteBO;
import medbay.model.vo.AtendenteVO;
import medbay.view.Telas;

public class ListarAtendenteController implements Initializable{
	@FXML private TableView<AtendenteVO> tabelaAtendente;
    @FXML private TableColumn<AtendenteVO, Integer> ide;
    @FXML private TableColumn<AtendenteVO, String> nome;
	@FXML private TableColumn<AtendenteVO, String> cpf;
	@FXML private TableColumn<AtendenteVO, Integer> idade;
	@FXML private TableColumn<AtendenteVO, String> genero;
	@FXML private TableColumn<AtendenteVO, String> login;
	@FXML private TableColumn<AtendenteVO, String> senha;
	AtendenteBO bo = new AtendenteBO();
	
	public void initialize(URL url, ResourceBundle rb) {
    	listar();
    }
    
    public void listar(){ //AMADO??
		ObservableList<AtendenteVO> atendente = FXCollections.observableArrayList(bo.listar());
		ide.setCellValueFactory(new PropertyValueFactory<AtendenteVO, Integer>("id"));
		nome.setCellValueFactory(new PropertyValueFactory<AtendenteVO, String>("nome"));
		cpf.setCellValueFactory(new PropertyValueFactory<AtendenteVO, String>("cpf"));
		idade.setCellValueFactory(new PropertyValueFactory<AtendenteVO, Integer>("idade"));
		genero.setCellValueFactory(new PropertyValueFactory<AtendenteVO, String>("genero"));
		login.setCellValueFactory(new PropertyValueFactory<AtendenteVO, String>("login"));
		senha.setCellValueFactory(new PropertyValueFactory<AtendenteVO, String>("senha"));
		tabelaAtendente.setItems(atendente);
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
