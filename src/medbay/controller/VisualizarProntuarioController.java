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
import medbay.model.vo.ProntuarioVO;
import medbay.view.Telas;

public class VisualizarProntuarioController implements Initializable {
	@FXML private TableView<ProntuarioVO> tabelaProntuario;
	@FXML private TableColumn<ProntuarioVO, Integer> ide;
	@FXML private Label nome;
	@FXML private TableColumn<ProntuarioVO, String> exame;
	@FXML private TableColumn<ProntuarioVO, String> data_consulta;
	@FXML private TableColumn<ProntuarioVO, String> hora_consulta;
	@FXML private TableColumn<ProntuarioVO, String> observacao;
	private static ConsultaVO consulta = new ConsultaVO();
	ProntuarioBO boPront = new ProntuarioBO();
	
	public void initialize(URL url, ResourceBundle rb) {
		listar();
		nome.setText(consulta.getPaciente().getNome());
	}
	
	public void listar(){
		ObservableList<ProntuarioVO> prontuario = FXCollections.observableArrayList(boPront.listar(consulta));
		ide.setCellValueFactory(new PropertyValueFactory<ProntuarioVO, Integer> ("id"));
		exame.setCellValueFactory((TableColumn.CellDataFeatures<ProntuarioVO, String> par) -> new SimpleStringProperty(par.getValue().getExame().getNome()));
		data_consulta.setCellValueFactory(new PropertyValueFactory<ProntuarioVO, String> ("dataString"));
		
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
