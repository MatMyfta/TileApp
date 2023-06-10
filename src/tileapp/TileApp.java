/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tileapp;

import java.util.Iterator;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author acer
 */
public class TileApp extends Application implements EventHandler<KeyEvent>{
    
    Tiles ts;
    HBox sub;
    
    @Override
    public void start(Stage primaryStage) {
	
	int N = getUserInput();
	
	Button riordina = new Button("Riordina");
	
	ts = new Tiles(this,N);
	sub = new HBox();
	
	VBox root = new VBox();
	root.getChildren().add(riordina);
	root.getChildren().add(ts);
	root.getChildren().add(sub);
	
	
	riordina.setOnAction((e) -> { ts.sort(); });
		
	Scene scene = new Scene(root, 600, 800);
	
	primaryStage.setTitle("Hello World!");
	primaryStage.setScene(scene);
	primaryStage.show();
    }
    
    /**
     * metodo che chiede all'utente il numero di Tiles
     * @return N numero di tiles
     */
    int getUserInput() {
	int n=0;
	do {
	    TextInputDialog tid = new TextInputDialog();
	    String s = tid.showAndWait().get();
	    try  {
		n = Integer.valueOf(s);
	    } catch (Exception e) { }
	} while (n<=3 || n>=11);
	return n;
    }
    
    @Override
    public void handle(KeyEvent e) {
	String c = e.getCharacter();
	switch (c) {
	    case "r" : 
	    case "R" :
		ts.sort();
		break;
	    case "0" :
	    case "1" :
	    case "2" :
	    case "3" :
	    case "4" :
	    case "5" :
	    case "6" :
	    case "7" :
	    case "8" :
	    case "9" :
		for (Iterator<Node> it = ts.getChildren().iterator(); it.hasNext();) {
		    Tile t = (Tile) it.next();
		    if (t instanceof SquareTile)
			((SquareTile) t).decrement(ts);
		    else 
			((CircleTile) t).increment(ts);
		}
		break;
	}
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	launch(args);
    }
    
}
