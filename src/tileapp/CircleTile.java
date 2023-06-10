/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tileapp;

import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

/**
 *
 * @author acer
 */
public final class CircleTile extends Tile{
    CircleTile(int n, Tiles ts) {
	super(new Circle(30),n);
	
	addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
	    this.increment(ts);
	});
    }
    
    public void increment (Tiles ts) {
	int n = super.n;
	n = (n+1 > 9 ? 0 : n+1);
	super.n = n;
	super.t.setText(Integer.toString(n));
	ts.performAction(this);
    }

    @Override
    public boolean isEqual(Tile t) {
	return this.getClass()==t.getClass() && this.n.compareTo(t.n)==0;
    }
}
