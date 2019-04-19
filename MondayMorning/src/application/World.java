package application;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.TimelineBuilder;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.KeyCode;

public class World {
	private Entity e;
	private Scene s;
	private Group g;
	final int MOVEMENT_MULTIPLIER = 10;
	private HashMap<KeyCode, Integer> pressedKeys;
	
	public World(double width, double height) 
	{
		e = new Entity(new Vector2(0,0));
		g = new Group();
		s = new Scene(g, width, height, Color.WHITE);
		pressedKeys = new HashMap<KeyCode, Integer>();
		s.setOnKeyPressed(key -> {pressedKeys.put(key.getCode(), MOVEMENT_MULTIPLIER);});
		s.setOnKeyReleased(key -> {pressedKeys.remove(key.getCode());});
	}
	
	public void init() {
		e.init("lonk.png");
		Utils.Log("Successfully initalized the game world.");
	
	}
	
	public void update(double deltaTime) {
		
		
		
	}
	
	public void draw(GraphicsContext gc)
	{
		e.draw(gc);
	}
	
	public Scene getScene() { return s; }
	
	public Group getGroup() { return g; }

}
