/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tileapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.TilePane;

/**
 *
 * @author acer
 */
public final class Tiles extends TilePane {
    
    List<Tile> list = new ArrayList();
    TileApp app;
    
    Tiles(TileApp app, int n) {
	this.app = app;
	this.setOrientation(Orientation.VERTICAL);
	for (int i = 0; i < n; i++) {
	    int x = new Random().nextInt()%10;
	    x = (x<0 ? -x : x);
	    if (this.getChildren().size() < n/2) {
		SquareTile st = new SquareTile(x, this);
		while (this.containsTile(st)) {
		    x = new Random().nextInt()%10;
		    x = (x<0 ? -x : x);
		    st = new SquareTile(x, this);
		}
		this.getChildren().add(st);
		list.add(st);
	    }
	    else {
		CircleTile ct = new CircleTile(x, this);
		while (this.containsTile(ct)) {
		    x = new Random().nextInt()%10;
		    x = (x<0 ? -x : x);
		    ct = new CircleTile(x, this);
		} 
		this.getChildren().add(ct);
		list.add(ct);
	    }
	}
	this.setOrientation(Orientation.VERTICAL);
	this.setAlignment(Pos.CENTER);
	this.setMinHeight(650.0);
    }
    
    public boolean containsTile(Tile t) {
	boolean b = false;
	for (Iterator<Node> it = this.getChildren().iterator(); it.hasNext();) {
	    Tile tile = (Tile) it.next();
	    b |= tile.isEqual(t);
	}
	return b;
    }
    
    public Tile checkDuplicates(Tile t1) {
	for (Node t : this.getChildren()) {
	    if (((Tile)t).isEqual(t1)) {
		return (Tile)t;
	    }
	}
	return null;
    }
    
    public void performAction(Tile t1) {
	Tile t = checkDuplicates(t1);
	if (t!=null) {
	    getChildren().removeAll(t,t1);
	    this.app.sub.getChildren().addAll(t,t1);
	}
    }
    
    public void sort() {
	getChildren().removeAll();
	Collections.sort(list);
	getChildren().addAll(list);
    }
    
}
