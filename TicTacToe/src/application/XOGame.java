package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class XOGame extends Application {

	private static final String X_LABEL = "X", O_LABEL = "O";
	private static final int X_TRUN = 0; // O_TRUN = 1;
	private static final int MASK = 1;
	private static final int WIDTH = 400, HEIGHT = 400;
	private static final int N = 3;

	private int current = X_TRUN;
	private Label[][] board;
	private GridPane layout;
	private Label statusLabel;
	private HBox buttonsHBox;

	@Override
	public void start(Stage primaryStage) {

		layout = new GridPane();
		layout.setAlignment(Pos.CENTER);
		populateLayout();

		statusLabel = new Label(String.format("It's %c turn.", (current == X_TRUN) ? 'X' : 'O'));
		statusLabel.setStyle("-fx-font-size: 30px; -fx-text-fill: white;");
		statusLabel.setPadding(new Insets(10));

		Label playAgainLabel = new Label("Do you want to play again?");
		playAgainLabel.setStyle("-fx-font-size: 15px; -fx-text-fill: white;");

		Button yesBtn = new Button(" Yes ");
		yesBtn.setOnAction(e -> handleYesBtn());
		Button noBtn = new Button(" No ");
		noBtn.setOnAction(e -> handleNoBtn());

		buttonsHBox = new HBox(10, playAgainLabel, yesBtn, noBtn);
		buttonsHBox.setPadding(new Insets(10));
		buttonsHBox.setVisible(false);

		BorderPane bp = new BorderPane();
		bp.setTop(statusLabel);
		bp.setCenter(layout);
		bp.setBottom(buttonsHBox);
		bp.setStyle("-fx-background-color: #2C2C2C");

		BorderPane.setAlignment(statusLabel, Pos.CENTER);

		primaryStage.setScene(new Scene(bp, WIDTH, HEIGHT));
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	private void handleYesBtn() {
		resetGame();
	}

	private void handleNoBtn() {
		System.exit(1);
	}

	private void handleMouseClick(MouseEvent e) {
		Label xolabel = (Label) e.getSource();

		if (!xolabel.getText().equals(""))
			return;

		if (current == X_TRUN)
			xolabel.setText(X_LABEL);
		else
			xolabel.setText(O_LABEL);

		if (checkWin(xolabel.getText())) {
			displayGameResult("win");
			buttonsHBox.setVisible(true);
			current ^= MASK;
			return;
		} else if (isFull()) {
			displayGameResult("draw");
			buttonsHBox.setVisible(true);
			current ^= MASK;
			return;
		}

		current ^= MASK;
		statusLabel.setText(String.format("It's %c turn.", (current == X_TRUN) ? 'X' : 'O'));
	}

	private void populateLayout() {
		board = new Label[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				Label l = new Label();
				l.setAlignment(Pos.CENTER);
				l.setStyle("-fx-font-size: 60px; -fx-font-weight: bold; -fx-text-fill: white;"
						+ " -fx-border-color: orange; -fx-border-width: 3px;");
				l.prefWidthProperty().bind(layout.widthProperty().divide(N));
				l.prefHeightProperty().bind(layout.heightProperty().divide(N));
				l.setOnMouseClicked(e -> handleMouseClick(e));
				layout.add(l, i, j);
				board[i][j] = l;
			}
	}

	private void resetGame() {
		emptyPane();
		buttonsHBox.setVisible(false);
		layout.setDisable(false);
		statusLabel.setText(String.format("It's %c turn.", (current == X_TRUN) ? 'X' : 'O'));
	}

	private void emptyPane() {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				board[i][j].setText("");
	}

	private boolean checkWin(String xo) {
		// Check horizontal lines.
		for (int i = 0; i < N; i++)
			if (board[i][0].getText().equals(xo)
					&& board[i][1].getText().equals(xo)
					&& board[i][2].getText().equals(xo))
				return true;

		// Check vertical lines.
		for (int i = 0; i < N; i++)
			if (board[0][i].getText().equals(xo)
					&& board[1][i].getText().equals(xo)
					&& board[2][i].getText().equals(xo))
				return true;

		// Check the diagonals.
		if (board[0][0].getText().equals(xo)
				&& board[1][1].getText().equals(xo)
				&& board[2][2].getText().equals(xo))
			return true;

		if (board[0][2].getText().equals(xo)
				&& board[1][1].getText().equals(xo)
				&& board[2][0].getText().equals(xo))
			return true;

		// No winning condition, return false.
		return false;
	}

	private boolean isFull() {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				if (board[i][j].getText().equals(""))
					return false;
		return true;
	}

	private void displayGameResult(String status) {
		layout.setDisable(true);
		String resultText = (status.equals("win")) ? String.format("%c has won!!", (current == X_TRUN) ? 'X' : 'O')
				: "Draw :/";
		statusLabel.setText(resultText);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
