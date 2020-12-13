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
	@FXML private TableColumn<PacienteVO, PacienteVO> columnEdit;
	@FXML private TableColumn<PacienteVO, PacienteVO> columnDelete;
	
	public static final String PEN_SOLID = "M290.74 93.24l128.02 128.02-277.99 277.99-114.14 12.6C11.35 513.54-1.56 500.62.14 485.34l12.7-114.22 277.9-277.88zm207.2-19.06l-60.11-60.11c-18.75-18.75-49.16-18.75-67.91 0l-56.55 56.55 128.02 128.02 56.55-56.55c18.75-18.76 18.75-49.16 0-67.91z";
	public static final String TRASH_SOLID = "M432 32H312l-9.4-18.7A24 24 0 0 0 281.1 0H166.8a23.72 23.72 0 0 0-21.4 13.3L136 32H16A16 16 0 0 0 0 48v32a16 16 0 0 0 16 16h416a16 16 0 0 0 16-16V48a16 16 0 0 0-16-16zM53.2 467a48 48 0 0 0 47.9 45h245.8a48 48 0 0 0 47.9-45L416 128H32z";
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
		sangue.setCellValueFactory(new PropertyValueFactory<PacienteVO, String>("tipoSangue"));
		//System.out.println(pacientes.get(0).getTipoSangue());
		tabelaPaciente.setItems(pacientes);
		
		Utils.initButtons(columnEdit, 15, PEN_SOLID, "svg-gray", (PacienteVO pacientevo, ActionEvent event) -> {
			System.out.println("Você clicou para editar as informações de: " + pacientevo.getNome());
			// Aqui vai toda a lógica para editar o exame
			try {
				EditarPacienteController.setPaciente(pacientevo);
				Telas.telaEditarPaciente();
			}catch(Exception e) {
				e.printStackTrace();
			}
			//aux.editar(vo);
		});
		Utils.initButtons(columnDelete, 15, TRASH_SOLID, "svg-red", (PacienteVO pacientevo, ActionEvent event) -> {
			System.out.println("Você clicou para deletar as informações de: " + pacientevo.getId());
			// Aqui vai toda a lógica para deletar o exame
			try {
				bo.excluir(pacientevo);
				Telas.telaEntrarPaciente();
			}catch(Exception e) {
				e.printStackTrace();
			}
		});
    }
	
	public void cadastrarConsulta(ActionEvent event) {
		
	}
	
	private int num;
	public void setNum(int num){
		this.num = num;
	}
	public int getNum() {
		return num;
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
