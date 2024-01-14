package application;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Act3 extends Application {
	
	private static final String BTN_STYLE_CSS = "-fx-background-color: white;"
			+ " -fx-font-family: 'Times New Roman'; -fx-font-size: 15;"
			+ " -fx-border-color: purple; -fx-border-width: 2;";

	@Override
	public void start(Stage primaryStage) {
		final String[] MONTHS = {"January", "February", "March", "April", "May", "June",
				"July", "August", "September", "October", "November", "December"};
		final String[] DAYS = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		
		Calendar c = new GregorianCalendar(2004, 3, 14);
		final int CURRENT_DAY = c.get(Calendar.DAY_OF_MONTH);
		
		c.set(Calendar.DAY_OF_MONTH, 1);
		final int FIRST_DAY = c.get(Calendar.DAY_OF_WEEK);
		final int DAYS_IN_MONTH = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		GridPane pane = new GridPane(20, 20);
		for (int i = 0; i < 7; i++) {
			Label l = new Label(DAYS[i]);
			l.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
			pane.add(l, i, 0);
		}

		for (int i = 1; i <= DAYS_IN_MONTH + FIRST_DAY - 1; i++) {
			if (i < FIRST_DAY) continue;
			Label l = new Label(" " + (i - FIRST_DAY + 1) + " ");
			l.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
			if (i - FIRST_DAY + 1 == CURRENT_DAY) l.setStyle("-fx-border-color: purple");
			pane.add(l, (i - 1) % 7, (i-1) / 7 + 1);
		}
		pane.setAlignment(Pos.CENTER);
				
		Label monthYearLabel = new Label(String.format("%s - %d", MONTHS[c.get(Calendar.MONTH)], c.get(Calendar.YEAR)));
		monthYearLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
		
		Button priorBtn = new Button("Prior");
		priorBtn.setStyle(BTN_STYLE_CSS);
		Button nextBtn = new Button("Next");
		nextBtn.setStyle(BTN_STYLE_CSS);
		HBox hBox = new HBox(20, priorBtn, nextBtn);
		hBox.setAlignment(Pos.CENTER);
		
		BorderPane layout = new BorderPane(pane, monthYearLabel, null, hBox, null);
		BorderPane.setAlignment(monthYearLabel, Pos.CENTER);
		
		layout.setPadding(new Insets(20));
		layout.setStyle("-fx-border-color: purple; -fx-border-width: 5;");
		
		Scene scene = new Scene(layout, 600, 350);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Fancy Calendar");
		primaryStage.setMinWidth(600);
		primaryStage.setMinHeight(350);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}









