package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.TimelineBuilder;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class World  extends AnimationTimer {
	private Entity e;
	private Stage s;
	
	public World(Stage stage) 
	{
		e = new Entity(new Vector2(0,0));
		s = stage;
	}
	
	public void init() {
		e.init("lonk.png");
		Utils.Log("Successfully initalized the game world.");
	
	}

	//handle is our game loop
	@Override
	public void handle(long arg0) {
		
	}

}
