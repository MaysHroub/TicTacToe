package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Act2 extends Application {

	@Override
	public void start(Stage primaryStage) {
		Label fileNameLabel = new Label("File name: ");
		fileNameLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
		Label contentLabel = new Label("file content...");
		contentLabel.setStyle("-fx-text-fill: white; -fx-font-size: 25;");
		TextField textField = new TextField("data.txt");
		textField.setStyle("-fx-border-color: #D97E1B; -fx-border-width: 2;");
		Button loadBtn = new Button(" Load ");
		loadBtn.setStyle("-fx-border-color: orange; -fx-border-width: 1; -fx-background-color: white;");
		Button saveBtn = new Button("Save");
		saveBtn.setStyle("-fx-border-color: orange; -fx-border-width: 1; -fx-background-color: white;");
		
		HBox hBox = new HBox(20, fileNameLabel, textField, loadBtn);
		hBox.setAlignment(Pos.CENTER);
		
		BorderPane pane = new BorderPane(contentLabel, hBox, null, saveBtn, null);
		pane.setStyle("-fx-border-color: #D97E1B; -fx-border-width: 4; -fx-background-color: #2C2C2C;");
		pane.setPadding(new Insets(30));
		BorderPane.setAlignment(saveBtn, Pos.CENTER);
		
		textField.prefWidthProperty().bind(pane.widthProperty().divide(2));
		saveBtn.prefWidthProperty().bind(pane.widthProperty().divide(3));
		
		Scene scene = new Scene(pane, 450, 300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Dummy file editor UI");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}












