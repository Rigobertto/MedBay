package projeto.view;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class TelaLogin extends Application{
	
	public static void main(String [] args){
		launch();
	}
	
	@Override
	public void start(Stage PrimaryStage) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("telas/TelaLogin.fxml"));
		Scene cena = new Scene(root);
		
		PrimaryStage.setTitle("Projeto MedBay");
		PrimaryStage.setScene(cena);
		PrimaryStage.show();
		
	}
}
