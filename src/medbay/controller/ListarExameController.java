package medbay.controller;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import medbay.model.bo.ExameBO;
import medbay.model.vo.ExameVO;
import medbay.view.Telas;
import java.util.ResourceBundle;
import java.net.URL;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListarExameController implements Initializable{
	@FXML private TableView<ExameVO> tabelaExame;
    @FXML private TableColumn<ExameVO, Integer> ide;
    @FXML private TableColumn<ExameVO, String> nome;
    @FXML private TableColumn<ExameVO, Integer> valor;
	@FXML private TableColumn<ExameVO, ExameVO> columnEdit;
	@FXML private TableColumn<ExameVO, ExameVO> columnDelete;
	
	public static final String PEN_SOLID = "M290.74 93.24l128.02 128.02-277.99 277.99-114.14 12.6C11.35 513.54-1.56 500.62.14 485.34l12.7-114.22 277.9-277.88zm207.2-19.06l-60.11-60.11c-18.75-18.75-49.16-18.75-67.91 0l-56.55 56.55 128.02 128.02 56.55-56.55c18.75-18.76 18.75-49.16 0-67.91z";
	public static final String TRASH_SOLID = "M432 32H312l-9.4-18.7A24 24 0 0 0 281.1 0H166.8a23.72 23.72 0 0 0-21.4 13.3L136 32H16A16 16 0 0 0 0 48v32a16 16 0 0 0 16 16h416a16 16 0 0 0 16-16V48a16 16 0 0 0-16-16zM53.2 467a48 48 0 0 0 47.9 45h245.8a48 48 0 0 0 47.9-45L416 128H32z";
    ExameBO<ExameVO> aux = new ExameBO<ExameVO>();
    
    public void initialize(URL url, ResourceBundle rb) {
    	listar();
    }
    
    public void listar(){ ///AMADO??
		ObservableList<ExameVO> exame = FXCollections.observableArrayList(aux.listar());
		ide.setCellValueFactory(new PropertyValueFactory<ExameVO, Integer>("id"));
		nome.setCellValueFactory(new PropertyValueFactory<ExameVO, String>("nome"));
		valor.setCellValueFactory(new PropertyValueFactory<ExameVO, Integer>("valor"));
		tabelaExame.setItems(exame);
		
		Utils.initButtons(columnEdit, 15, PEN_SOLID, "svg-gray", (ExameVO examevo, ActionEvent event) -> {
			System.out.println("Você clicou para editar as informações de: " + examevo.getNome());
			// Aqui vai toda a lógica para editar o exame
			try {
				EditarExameController.setRecebeExame(examevo);
				Telas.telaEditarExame();
			}catch(Exception e) {
				e.printStackTrace();
			}
			//aux.editar(vo);
		});
		Utils.initButtons(columnDelete, 15, TRASH_SOLID, "svg-red", (ExameVO examevo, ActionEvent event) -> {
			System.out.println("Você clicou para deletar as informações de: " + examevo.getId());
			// Aqui vai toda a lógica para deletar o exame
			try {
				aux.excluir(examevo);
				Telas.telaEntrarExame();
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
	
	public void entrarCadastrarExame() {
		try {
			Telas.telaCadastrarExame();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
