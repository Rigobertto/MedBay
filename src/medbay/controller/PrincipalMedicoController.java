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
import medbay.model.vo.ConsultaVO;
import medbay.model.vo.MedicoVO;
import medbay.model.vo.UsuarioVO;
import medbay.view.Telas;

public class PrincipalMedicoController implements Initializable{
	@FXML private TableView<ConsultaVO> tabelaConsulta;
	@FXML private TableColumn<ConsultaVO, Integer> ideConsulta;
	@FXML private TableColumn<ConsultaVO, String> nomePaciente;
	@FXML private TableColumn<ConsultaVO, String> cpfPaciente;
	@FXML private TableColumn<ConsultaVO, String> sanguePaciente;
	@FXML private TableColumn<ConsultaVO, Float> pesoPaciente;
	@FXML private TableColumn<ConsultaVO, Float> alturaPaciente;
	@FXML private TableColumn<ConsultaVO, String> nomeExame;
	@FXML private TableColumn<ConsultaVO, String> data;
	@FXML private TableColumn<ConsultaVO, String> hora;
	MedicoBO<MedicoVO> bo = new MedicoBO<MedicoVO>();
	public void initialize(URL url, ResourceBundle rb) {
    	listar();
    }
	
	public void listar(){ //AMADO??
		ObservableList<ConsultaVO> consulta = FXCollections.observableArrayList(bo.listarID()); //IMPELEMNTAR LIST ID
		ideConsulta.setCellValueFactory(new PropertyValueFactory<ConsultaVO, Integer>("id"));
		nomePaciente.setCellValueFactory(new PropertyValueFactory<ConsultaVO, String>("nome"));
		cpfPaciente.setCellValueFactory(new PropertyValueFactory<ConsultaVO, String>("cpf"));
		sanguePaciente.setCellValueFactory(new PropertyValueFactory<ConsultaVO, String>("TipoSangue")); // Talvez o q esta entre "" esteja incorrto
		alturaPaciente.setCellValueFactory(new PropertyValueFactory<ConsultaVO, Float>("altura"));
		pesoPaciente.setCellValueFactory(new PropertyValueFactory<ConsultaVO, Float>("peso"));
		nomeExame.setCellValueFactory(new PropertyValueFactory<ConsultaVO, String>("nome"));
		data.setCellValueFactory(new PropertyValueFactory<ConsultaVO, String>("data"));
		hora.setCellValueFactory(new PropertyValueFactory<ConsultaVO, String>("hora"));
		
		tabelaConsulta.setItems(consulta);
    }
	public void excluir(ActionEvent event) {
		
	}
	public void logOut(ActionEvent event) {
		try {
			Telas.telaLogin();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void editarProntuario(ActionEvent event) {
		try {
			Telas.telaEditarProntuario();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
