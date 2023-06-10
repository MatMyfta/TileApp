/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tileapp;

import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author acer
 */
public class SquareTile extends Tile {
    
    public SquareTile(int n, Tiles ts) {
	super(new Rectangle(60,60), n);
	
	addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
	    this.decrement(ts);
	});
    }
    
    public void decrement(Tiles ts) {
	int n = super.n;
	n = (n-1 < 0 ? 9 : n-1);
	super.n = n;
	super.t.setText(Integer.toString(n));
	ts.performAction(this);
    }
    
    @Override
    public boolean isEqual(Tile t) {
	return t instanceof SquareTile && this.n.compareTo(t.n)==0;
    }
}
