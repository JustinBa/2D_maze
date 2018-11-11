package Program;

import java.io.File;
import java.io.FileNotFoundException;
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
	public void start(Stage stage) throws FileNotFoundException {
		myStage = stage;
		File mapOne = new File("src\\game1.txt");
		File mapTwo = new File("src\\game2.txt");
		
		Random rand = new Random();
		Scanner scan = null;
		
		if(rand.nextInt() % 2 == 0) {
			scan = new Scanner(mapOne);
		}
		else {
			scan = new Scanner(mapTwo);
		}
		/*Scanner scanlin = null;
		int i = 0;
		String[][] tiles = new String[10][5];
		for(int x = 0; x < 10; x = x + 1) {
			String lins = scan.nextLine();
			if(i == 0) {
				scanlin = new Scanner(lins);
				i = i + 1;
			}
			for(int y = 0; y < 5; y = y + 1) {
				String current_int = scanlin.nextLine();
				if(current_int.equals("0")) {
					tiles[x][y] = "board board_" + x + "_" + y + "= new board(" + x + ", " + y + ", " + false + ")";
					System.out.println(tiles[x][y]);
				}
				else if(current_int.equals("1")){
					tiles[x][y] = "board board_" + x + "_" + y + "= new board(" + x + ", " + y + ", " + true + ")";
					System.out.println(tiles[x][y]);
				}
			}
		}
*/
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
