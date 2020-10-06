package dad.javafx.cambiodivisa;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
	
	private Divisa euro = new Divisa("Euro", 1.0);
	private Divisa libra = new Divisa("Libra", 0.9);
	private Divisa dolar = new Divisa("Dolar", 1.2);
	private Divisa yen = new Divisa("Yen", 133.6);
	
	private Divisa [] divisas = { euro, libra, dolar, yen };

	private TextField origenText, destinoText;
	private ComboBox<Divisa> origenCombo;
	private ComboBox<Divisa> destinoCombo;
	private Button cambiarButton;
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		origenText = new TextField("0");
		origenText.setPrefColumnCount(4);

		origenCombo = new ComboBox<>();
		origenCombo.getItems().addAll(divisas);
		origenCombo.getSelectionModel().select(euro);
//		origenCombo.getSelectionModel().selectFirst(); // selecciona el primer item del combo
		
		HBox origenBox = new HBox();
		origenBox.setAlignment(Pos.BASELINE_CENTER);
		origenBox.setSpacing(5);
		origenBox.getChildren().addAll(origenText, origenCombo);
		
		destinoText = new TextField("0");
		destinoText.setPrefColumnCount(4);
		destinoText.setEditable(false);
		
		destinoCombo = new ComboBox<>();
		destinoCombo.getItems().addAll(divisas);
		destinoCombo.getSelectionModel().select(libra);

		HBox destinoBox = new HBox();
		destinoBox.setAlignment(Pos.BASELINE_CENTER);
		destinoBox.setSpacing(5);
		destinoBox.getChildren().addAll(destinoText, destinoCombo);
		
		cambiarButton = new Button("Cambiar");
		cambiarButton.setOnAction(e -> onCambiarAction(e));
		
		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(origenBox, destinoBox, cambiarButton);
		
		Scene scene = new Scene(root, 320, 200);
		
		primaryStage.setTitle("Cambio de divisa");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	private void onCambiarAction(ActionEvent e) {
		Double cantidadOrigen = Double.parseDouble(origenText.getText());
		Divisa divisaOrigen = origenCombo.getSelectionModel().getSelectedItem();
		Divisa divisaDestino = destinoCombo.getSelectionModel().getSelectedItem();
		
		Double enEuros = divisaOrigen.toEuro(cantidadOrigen);
		Double cantidadDestino = divisaDestino.fromEuro(enEuros);
		
		destinoText.setText("" + cantidadDestino);
	}

	public static void main(String[] args) {
		launch(args);
	}

}
