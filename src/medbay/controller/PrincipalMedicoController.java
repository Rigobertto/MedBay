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
import medbay.model.bo.ConsultaBO;
import medbay.model.bo.MedicoBO;
import medbay.model.vo.ConsultaVO;
import medbay.model.vo.MedicoVO;
import medbay.model.vo.UsuarioVO;
import medbay.view.Telas;

public class PrincipalMedicoController implements Initializable{
	@FXML private TableView<ConsultaVO> tabelaConsulta;
	@FXML private TableColumn<ConsultaVO, Integer> ide;
	@FXML private TableColumn<ConsultaVO, String> nome;
	@FXML private TableColumn<ConsultaVO, String> genero;
	@FXML private TableColumn<ConsultaVO, String> sangue;
	@FXML private TableColumn<ConsultaVO, String> peso;
	@FXML private TableColumn<ConsultaVO, String> altura;
	@FXML private TableColumn<ConsultaVO, String> exame;
	@FXML private TableColumn<ConsultaVO, String> data_consulta;
	@FXML private TableColumn<ConsultaVO, String> hora_consulta;
	@FXML private Label lblMensagem;
	MedicoBO<MedicoVO> boMed = new MedicoBO<MedicoVO>();
	private static UsuarioVO user = new UsuarioVO();
	MedicoVO medico = boMed.buscaId(user.getId());
	ConsultaBO boCon = new ConsultaBO();
	
	public void initialize(URL url, ResourceBundle rb) {
    	listar();
    }
	
	public void listar(){ //AMADO??
		ObservableList<ConsultaVO> consulta = FXCollections.observableArrayList(boCon.listarIdMedico(medico)); 
		ide.setCellValueFactory(new PropertyValueFactory<ConsultaVO, Integer>("id"));
		nome.setCellValueFactory((TableColumn.CellDataFeatures<ConsultaVO, String> param) -> new SimpleStringProperty(param.getValue().getPaciente().getNome()));
		exame.setCellValueFactory((TableColumn.CellDataFeatures<ConsultaVO, String> par) -> new SimpleStringProperty(par.getValue().getExame().getNome()));
		sangue.setCellValueFactory((TableColumn.CellDataFeatures<ConsultaVO, String> param) -> new SimpleStringProperty(param.getValue().getPaciente().getTipoSangue()));
		altura.setCellValueFactory((TableColumn.CellDataFeatures<ConsultaVO, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getPaciente().getAltura())));
		peso.setCellValueFactory((TableColumn.CellDataFeatures<ConsultaVO, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getPaciente().getPeso())));
		genero.setCellValueFactory((TableColumn.CellDataFeatures<ConsultaVO, String> param) -> new SimpleStringProperty(param.getValue().getPaciente().getGenero()));
		data_consulta.setCellValueFactory(new PropertyValueFactory<ConsultaVO, String>("dataString"));
		hora_consulta.setCellValueFactory(new PropertyValueFactory<ConsultaVO, String>("horaString"));
		
		tabelaConsulta.setItems(consulta);
    }
	public void excluir(ActionEvent event){
		try {
		EditarProntuarioController.setConsulta(tabelaConsulta.getSelectionModel().getSelectedItem());
		Telas.telaEditarProntuario();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void prontuario(ActionEvent event) {
		try {
			VisualizarProntuarioController.setConsulta(tabelaConsulta.getSelectionModel().getSelectedItem());
			Telas.telaEntrarProntuario();
			
		}catch(Exception e){
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
	
	public static UsuarioVO getUser() {
		return user;
	}

	public static void setUser(UsuarioVO us) {
		user = us;
	}
}
