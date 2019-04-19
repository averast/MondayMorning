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
	//constants
	final int fps = 60;
	final int ms_delay = 1000 / fps;
	final double second_delay = 1.0 / ms_delay; 
	
	@Override
	public void start(Stage stage) {
		
		stage.setTitle("Monday Morning");
		World theworld = new World(stage.getWidth(), stage.getHeight());
		theworld.init();
		
		stage.setScene(theworld.getScene());
		
		Canvas canvas = new Canvas(800, 800);
		theworld.getGroup().getChildren().add(canvas);
		
		GraphicsContext gc = canvas.getGraphicsContext2D();

		Timeline gameLoop = new Timeline();
		gameLoop.setCycleCount(Timeline.INDEFINITE);
		
		KeyFrame gameStep = new KeyFrame(Duration.seconds(0.017),
			n -> {
				theworld.update(second_delay);
				theworld.draw(gc);
				
			});
		
		
		
		gameLoop.getKeyFrames().add(gameStep);
		gameLoop.play();
		stage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	
	
}
