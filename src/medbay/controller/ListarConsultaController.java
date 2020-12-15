package medbay.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import medbay.model.bo.ConsultaBO;
import medbay.model.bo.PacienteBO;
import medbay.model.vo.ConsultaVO;

import medbay.view.Telas;

public class ListarConsultaController implements Initializable{
	@FXML private TableView<ConsultaVO> tabelaConsulta;
    @FXML private TableColumn<ConsultaVO, Integer> ide;
    @FXML private TableColumn<ConsultaVO, String> nome;
	//@FXML private TableColumn<ConsultaVO, String> cpf;
	//@FXML private TableColumn<ConsultaVO, String> sangue;
	@FXML private TableColumn<ConsultaVO, String> medico;
	@FXML private TableColumn<ConsultaVO, String> exame;
	@FXML private TableColumn<ConsultaVO, String> data_consulta; // talez nao seja string
	@FXML private TableColumn<ConsultaVO, String> hora_consulta;
	@FXML private TableColumn<ConsultaVO, ConsultaVO> columnEdit;
	@FXML private TableColumn<ConsultaVO, ConsultaVO> columnDelete;
	@FXML private TextField buscaData;
	@FXML private TextField buscaNome;
	public static final String PEN_SOLID = "M290.74 93.24l128.02 128.02-277.99 277.99-114.14 12.6C11.35 513.54-1.56 500.62.14 485.34l12.7-114.22 277.9-277.88zm207.2-19.06l-60.11-60.11c-18.75-18.75-49.16-18.75-67.91 0l-56.55 56.55 128.02 128.02 56.55-56.55c18.75-18.76 18.75-49.16 0-67.91z";
	public static final String TRASH_SOLID = "M432 32H312l-9.4-18.7A24 24 0 0 0 281.1 0H166.8a23.72 23.72 0 0 0-21.4 13.3L136 32H16A16 16 0 0 0 0 48v32a16 16 0 0 0 16 16h416a16 16 0 0 0 16-16V48a16 16 0 0 0-16-16zM53.2 467a48 48 0 0 0 47.9 45h245.8a48 48 0 0 0 47.9-45L416 128H32z";
	ConsultaBO bo = new ConsultaBO();
	PacienteBO bop = new PacienteBO();
	
	public void initialize(URL url, ResourceBundle rb) {
		listar();
	}
	
	
	public void listar(){
		ObservableList<ConsultaVO> consulta = FXCollections.observableArrayList(bo.listar());
		ide.setCellValueFactory(new PropertyValueFactory<ConsultaVO, Integer> ("id"));
		nome.setCellValueFactory((TableColumn.CellDataFeatures<ConsultaVO, String> param) -> new SimpleStringProperty(param.getValue().getPaciente().getNome()));
		medico.setCellValueFactory((TableColumn.CellDataFeatures<ConsultaVO, String> param) -> new SimpleStringProperty(param.getValue().getMedico().getNome()));
		exame.setCellValueFactory((TableColumn.CellDataFeatures<ConsultaVO, String> par) -> new SimpleStringProperty(par.getValue().getExame().getNome()));
		hora_consulta.setCellValueFactory(new PropertyValueFactory<ConsultaVO, String>("horaString"));
		data_consulta.setCellValueFactory(new PropertyValueFactory<ConsultaVO, String>("dataString"));
		//data_consulta.setText("0");
		//hora_consulta.setText("0");
		tabelaConsulta.setItems(consulta);
		
		Utils.initButtons(columnEdit, 15, PEN_SOLID, "svg-gray", (ConsultaVO consultabo, ActionEvent event) -> {
//			System.out.println("Você clicou para editar as informações de: " + consultabo.getPaciente().getNome());
//			// Aqui vai toda a lógica para editar o exame
//			try {
//				EditarConsultaController.setConsultal(consultabo);
//				Telas.telaEditarConsulta();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//			//aux.editar(vo);
		});
		Utils.initButtons(columnDelete, 15, TRASH_SOLID, "svg-red", (ConsultaVO consultabo, ActionEvent event) -> {
//			System.out.println("Você clicou para deletar as informações de: " + consultabo.getId());
//			// Aqui vai toda a lógica para deletar o exame
//			try {
//				bo.excluir(consultabo);
//				Telas.telaEntrarConsulta();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
		});
    }
	
	//public void pesquisaNome(ActionEvent event) {
//		ObservableList<ConsultaVO> consulta = FXCollections.observableArrayList(bo.buscaNome());
//		ide.setCellValueFactory(new PropertyValueFactory<ConsultaVO, Integer> ("id"));
//		nome.setCellValueFactory((TableColumn.CellDataFeatures<ConsultaVO, String> param) -> new SimpleStringProperty(param.getValue().getPaciente().getNome()));
//		medico.setCellValueFactory((TableColumn.CellDataFeatures<ConsultaVO, String> param) -> new SimpleStringProperty(param.getValue().getMedico().getNome()));
//		exame.setCellValueFactory((TableColumn.CellDataFeatures<ConsultaVO, String> par) -> new SimpleStringProperty(par.getValue().getExame().getNome()));
//		hora_consulta.setCellValueFactory(new PropertyValueFactory<ConsultaVO, String>("horaString"));
//		data_consulta.setCellValueFactory(new PropertyValueFactory<ConsultaVO, String>("dataString"));
//		//data_consulta.setText("0");
//		//hora_consulta.setText("0");
//		tabelaConsulta.setItems(consulta);
//		
//		Utils.initButtons(columnEdit, 15, PEN_SOLID, "svg-gray", (ConsultaVO consultabo, ActionEvent event) -> {
//			System.out.println("Você clicou para editar as informações de: " + consultabo.getPaciente().getNome());
//			// Aqui vai toda a lógica para editar o exame
//			try {
//				EditarConsultaController.setConsultal(consultabo);
//				Telas.telaEditarConsulta();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//			//aux.editar(vo);
//		});
//		Utils.initButtons(columnDelete, 15, TRASH_SOLID, "svg-red", (ConsultaVO consultabo, ActionEvent event) -> {
////			System.out.println("Você clicou para deletar as informações de: " + consultabo.getId());
////			// Aqui vai toda a lógica para deletar o exame
////			try {
////				bo.excluir(consultabo);
////				Telas.telaEntrarConsulta();
////			}catch(Exception e) {
////				e.printStackTrace();
////			}
//		});
//	}
	
	public void logOut(ActionEvent event) {
		try {
			Telas.telaLogin();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void voltar(ActionEvent event) {
		try {
			Telas.telaInicioAtendente();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cadastrarConsulta(ActionEvent event) {
		try {
			Telas.telaCadastrarConsulta();
		}catch(Exception e) {
			e.printStackTrace();
		}
	} 
}
