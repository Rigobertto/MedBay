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
import medbay.model.vo.UsuarioVO;
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
	@FXML private TableColumn<MedicoVO, MedicoVO> columnEdit;
	@FXML private TableColumn<MedicoVO, MedicoVO> columnDelete;
	
	public static final String PEN_SOLID = "M290.74 93.24l128.02 128.02-277.99 277.99-114.14 12.6C11.35 513.54-1.56 500.62.14 485.34l12.7-114.22 277.9-277.88zm207.2-19.06l-60.11-60.11c-18.75-18.75-49.16-18.75-67.91 0l-56.55 56.55 128.02 128.02 56.55-56.55c18.75-18.76 18.75-49.16 0-67.91z";
	public static final String TRASH_SOLID = "M432 32H312l-9.4-18.7A24 24 0 0 0 281.1 0H166.8a23.72 23.72 0 0 0-21.4 13.3L136 32H16A16 16 0 0 0 0 48v32a16 16 0 0 0 16 16h416a16 16 0 0 0 16-16V48a16 16 0 0 0-16-16zM53.2 467a48 48 0 0 0 47.9 45h245.8a48 48 0 0 0 47.9-45L416 128H32z";
	MedicoBO<MedicoVO> bo = new MedicoBO<MedicoVO>();
	
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
		
		Utils.initButtons(columnEdit, 15, PEN_SOLID, "svg-gray", (MedicoVO medicovo, ActionEvent event) -> {
			System.out.println("Você clicou para editar as informações de: " + medicovo.getNome());
			// Aqui vai toda a lógica para editar o exame
			try {
				UsuarioVO user = new UsuarioVO();
				user.setId(medicovo.getId());
				user.setCpf(medicovo.getCpf());
				EditarAtendenteMedicoController.setUsaurio(user);
				Telas.telaEditarAtendenteMedico();
			}catch(Exception e) {
				e.printStackTrace();
			}
			//aux.editar(vo);
		});
		Utils.initButtons(columnDelete, 15, TRASH_SOLID, "svg-red", (MedicoVO medicovo, ActionEvent event) -> {
			System.out.println("Você clicou para deletar as informações de: " + medicovo.getId());
			// Aqui vai toda a lógica para deletar o exame
			try {
				bo.excluir(medicovo);
				Telas.telaEntrarMedico();
			}catch(Exception e) {
				e.printStackTrace();
			}
		});
		
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
