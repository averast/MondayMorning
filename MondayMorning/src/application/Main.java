package application;
	
import java.io.IOException;
import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import application.Utils;
import application.controller.GameController;
import javafx.event.*;

public class Main extends Application {
	private Stage stage;
	Parent root;
	Entity lonk;
	final int movementMultiplier = 10;
	@Override
	public void start(Stage stage) {
		
		stage.setTitle("Monday Morning");
		Group root = new Group();
		Scene scene = new Scene(root);
		
		stage.setScene(scene);
		
		Canvas canvas = new Canvas(800, 800);
		root.getChildren().add(canvas);
		
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		lonk = new Entity(new Vector2(0,0));
		
		lonk.init("lonk.png"); 
		
		Timeline gameLoop = new Timeline();
		gameLoop.setCycleCount(Timeline.INDEFINITE);
		
		final long tstart = System.currentTimeMillis();
		
		KeyFrame drawFrame = new KeyFrame(Duration.seconds(0.017),
				new EventHandler<ActionEvent> () 
				{
					public void handle(ActionEvent ae)
					{
						gc.clearRect(0, 0, 800, 800);
						lonk.draw(gc);
						
					}
				});
		
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent> ()
					{
						public void handle(KeyEvent ke)
						{
							KeyCode code = ke.getCode();
							int x = code == KeyCode.A ? -1 : code == KeyCode.D ? 1 : 0;
							int y = code == KeyCode.S ? 1 : code == KeyCode.W ? -1 : 0;
							
							lonk.move(x * movementMultiplier, y * movementMultiplier);
						}
					});
		
		gameLoop.getKeyFrames().add(drawFrame);
		gameLoop.play();
		
		stage.show();
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void switchScene(String fxmlPath)
	{
		try
		{
			root = FXMLLoader.load(getClass().getResource(fxmlPath));
			stage.setScene(new Scene(root));
			stage.show();
		}
		
		catch (IOException e)
		{
			Utils.CriticalFailure("Failed to switch the scenes", e);
		}
	}
	
	
	
}


/*
 * old code
 * 
 		this.stage = stage;
		
		try {
			root = FXMLLoader.load(getClass().getResource("/application/view/Title.fxml"));
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			Utils.CriticalFailure("Failed to set the scene", e);
		}
 * */
