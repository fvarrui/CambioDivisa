package dad.javafx.cambiodivisa;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

	private TextField origenText, destinoText;
	private ComboBox origenCombo, destinoCombo;
	private Button cambiarButton;
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		origenText = new TextField("0");
		origenText.setPrefColumnCount(4);

		origenCombo = new ComboBox();
		
		HBox origenBox = new HBox();
		origenBox.setAlignment(Pos.BASELINE_CENTER);
		origenBox.setSpacing(5);
		origenBox.getChildren().addAll(origenText, origenCombo);
		
		destinoText = new TextField("0");
		destinoText.setPrefColumnCount(4);
		
		destinoCombo = new ComboBox();

		HBox destinoBox = new HBox();
		destinoBox.setAlignment(Pos.BASELINE_CENTER);
		destinoBox.setSpacing(5);
		destinoBox.getChildren().addAll(destinoText, destinoCombo);
		
		cambiarButton = new Button("Cambiar");
		
		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(origenBox, destinoBox, cambiarButton);
		
		Scene scene = new Scene(root, 320, 200);
		
		primaryStage.setTitle("Cambio de divisa");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
