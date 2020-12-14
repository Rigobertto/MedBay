package medbay.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import medbay.model.bo.ProntuarioBO;
import medbay.model.vo.ConsultaVO;
import medbay.model.vo.ExameVO;
import medbay.model.vo.ProntuarioVO;
import medbay.view.Telas;

public class VisualizarProntuarioController implements Initializable {
	@FXML private TableView<ConsultaVO> tabelaProntuario;
	@FXML private TableColumn<ConsultaVO, Integer> ide;
	@FXML private Label nome;
	@FXML private TableColumn<ConsultaVO, String> exame;
	@FXML private TableColumn<ConsultaVO, String> data_consulta;
	@FXML private TableColumn<ConsultaVO, String> observacao;
	private static ConsultaVO consulta = new ConsultaVO();
	ProntuarioBO boPront = new ProntuarioBO();
	
	public void initialize(URL url, ResourceBundle rb) {
		listar();
		nome.setText(consulta.getPaciente().getNome());
	}
	
	public void listar(){
		ObservableList<ProntuarioVO> prontuario = FXCollections.observableArrayList(boPront.listar(consulta)); 
		ide.setCellValueFactory(new PropertyValueFactory<ProntuarioVO, Integer>("id"));
		exame.setCellValueFactory((TableColumn.CellDataFeatures<ConsultaVO, String> param) -> new SimpleStringProperty(param.getValue().getMedico().getNome()));
		data_consulta.setCellValueFactory(new PropertyValueFactory<ProntuarioVO, String>("data"));
		exame.setCellValueFactory(new PropertyValueFactory<ExameVO, String>("nome"));
		observacao.setCellValueFactory(new PropertyValueFactory<ProntuarioVO, String>("observacao")); // Talvez o q esta entre "" esteja incorreto
		
		tabelaProntuario.setItems(prontuario);
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
			Telas.telaInicioMedico();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ConsultaVO getConsulta() {
		return consulta;
	}

	public static void setConsulta(ConsultaVO cons) {
		consulta = cons;
	}
}
