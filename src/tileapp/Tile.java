/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tileapp;

import java.util.Comparator;
import javafx.scene.shape.Shape;
import java.util.Random;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


/**
 *
 * @author acer
 */
public abstract class Tile extends StackPane implements Comparable {
    
    Integer n;
    Shape s;
    Text t;
    Color c;
    
    Tile(Shape s, int n) {
	this.n = n;
	t = new Text();
	t.setText(Integer.toString(n));
	Random r = new Random(System.currentTimeMillis());
	c = new Color(r.nextDouble(), r.nextDouble(), r.nextDouble(), 1.0);
	t.setStroke(c.invert());
	s.setFill(c);
	s.setStroke(c.invert());
	this.s = s;
	getChildren().addAll(this.s, t);
    }
    
    @Override
    public int compareTo(Object obj) {
        if (obj instanceof Tile) {
            Tile t=(Tile)obj;
            return this.n-t.n;
        }
        return 0;
    }
    
    public abstract boolean isEqual(Tile t);
    
}
