package application;
	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;


public class Act1 extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		final int N = 3;
		
		GridPane layout = new GridPane();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int r = (int) (Math.random() * 2);
				Label label = new Label(r + "");
				label.setFont(new Font(30));
				label.prefHeightProperty().bind(layout.heightProperty().divide(N));
				label.prefWidthProperty().bind(layout.widthProperty().divide(N));
				label.setStyle("-fx-border-color: red; -fx-border-width: 4;");
				label.setAlignment(Pos.CENTER);
				layout.add(label, i, j);
			}
		}
		
		Scene scene = new Scene(layout, 300, 300);
				
		primaryStage.setScene(scene);
		primaryStage.setTitle("Display random 0 or 1");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
