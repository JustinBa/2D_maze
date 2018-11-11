package Program;

import java.io.File;
import java.util.Random;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class drever extends Application {
	private Stage myStage;
	private ImageView imageView;
	Player player;
	public static void main(String[] args) {

		launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
		myStage = stage;
		File mapOne = new File("src/Program/game1.txt");
		File mapTwo = new File("src/Program/game2.txt");
		
		Random rand = new Random();
		Scanner scan;
		
		if(rand.nextInt() % 2 == 0) {
			scan = new Scanner(mapOne);
		}
		else {
			scan = new Scanner(mapTwo);
		}
		scan.close();
		Image img = new Image("file:src/Player1.jpg");
		player = new Player(10,10,5,5, img);
		imageView = new ImageView(new Image("file:src/Player1.jpg"));
		imageView.setX(player.getX());
		imageView.setY(player.getY());
		imageView.setFitWidth(39);
		imageView.setFitHeight(65);
		
	    Group root = new Group(imageView);  
	    Scene scene = new Scene(root, 600, 500);
	    myStage.setTitle("Maze");  
	    myStage.setScene(scene);
	    myStage.show(); 

	    scene.setOnKeyPressed(this::listenUp);
	}
	public void listenUp(KeyEvent event){
		KeyCode myCode = event.getCode();
		
		if(myCode == KeyCode.A)
		{
			player.moveLeft();
			if(player.getX() < 0) {
				player.moveRight();
			}
		}
		else if(myCode == KeyCode.D)
		{
			player.moveRight();
			if(player.getX() > 564) {
				player.moveLeft();
			}
		}
		else if(myCode == KeyCode.S)
		{
			player.moveDown();
			if(player.getY() > 440) {
				player.moveUp();
			}
			
		}
		else if(myCode == KeyCode.W)
		{
			player.moveUp();
			if(player.getY() < 10) {
				player.moveDown();
			}
		}
	
	

		imageView.setX(player.getX());
		imageView.setY(player.getY());
		
		
	}

}
