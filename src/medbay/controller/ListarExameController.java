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
