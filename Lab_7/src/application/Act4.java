package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Act4 extends Application {

	@Override
	public void start(Stage primaryStage) {
		GridPane personalInfoGP = new GridPane(15, 10);
		populatePersonalInfoGridPane(personalInfoGP);
		personalInfoGP.setAlignment(Pos.CENTER);
		
		GridPane subjectsInfoGP = new GridPane(15, 10);
		subjectsInfoGP.setAlignment(Pos.CENTER);
		populateSubjectsInfoGridPane(subjectsInfoGP);
		ImageView imageView = new ImageView("file:C:\\Users\\ismae\\Downloads\\nizar.jpeg");
		imageView.setFitWidth(200);
		
		HBox hb = new HBox(40, subjectsInfoGP, imageView);
		hb.setAlignment(Pos.CENTER);
		
//		imageView.fitWidthProperty().bind(hb.widthProperty().divide(3));
//		imageView.setPreserveRatio(true);
		
		HBox btnHB = new HBox(20, new Button("Prior"), new Button("Next"));
		btnHB.setAlignment(Pos.CENTER);
		Label avgLabel = new Label(String.format("Average = %.2f%%", 96.6f));
		avgLabel.setStyle("-fx-font-family: 'Times New Roman'; -fx-font-size: 20; -fx-font-weight: bold;");
		VBox vb = new VBox(10, avgLabel, btnHB);
		vb.setAlignment(Pos.CENTER);
		
		BorderPane layout = new BorderPane(hb, personalInfoGP, null, vb, null);
		layout.setPadding(new Insets(20));
		layout.setStyle("-fx-border-color: orange; -fx-border-width: 5;");
		
		Scene scene = new Scene(layout, 600, 500);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Dummy Tawjihi Editor");
		primaryStage.setMinHeight(500);
		primaryStage.setMinWidth(580);
		primaryStage.show();
	}

	private void populateSubjectsInfoGridPane(GridPane gp) {
		gp.add(new Label("Math"), 0, 0);
		gp.add(new Label("English"), 0, 1);
		gp.add(new Label("Biology"), 0, 2);
		gp.add(new Label("Chemestry"), 0, 3);
		
		gp.add(new Label("Mandatory"), 1, 0);
		gp.add(new Label("Mandatory"), 1, 1);
		gp.add(new Label("Elective 1"), 1, 2);
		gp.add(new Label("Elective 1"), 1, 3);
		
		gp.add(new Label("198/200"), 2, 0);
		gp.add(new Label("99/100"), 2, 1);
		gp.add(new Label("98/100"), 2, 2);
		gp.add(new Label("100/100"), 2, 3);
	}

	private void populatePersonalInfoGridPane(GridPane gp) {
		gp.add(new Label("ID:"), 0, 0);
		gp.add(new Label("Seat number:"), 0, 1);
		gp.add(new Label("Year:"), 0, 2);
		
		TextField idTF = new TextField("992574630");
		idTF.setPrefColumnCount(8);
		TextField seatNumTF = new TextField("27033386");
		seatNumTF.setPrefColumnCount(8);
		TextField yearTF = new TextField("2024");
		yearTF.setPrefColumnCount(8);
		gp.add(idTF, 1, 0);
		gp.add(seatNumTF, 1, 1);
		gp.add(yearTF, 1, 2);
		
		gp.add(new Label("  Name:"), 2, 0);
		gp.add(new Label("  Branch:"), 2, 1);
		gp.add(new Label("  School:"), 2, 2);
		
		gp.add(new TextField("Nizar Banat"), 3, 0);
		gp.add(new TextField("Scientific"), 3, 1);
		gp.add(new TextField("Hebron"), 3, 2);
		
		gp.add(new Label("Gender:"), 4, 0);
		TextField genderTF = new TextField("M");
		genderTF.setPrefColumnCount(1);
		gp.add(genderTF, 5, 0);
	}

	public static void main(String[] args) {
		launch(args);
	}

}
