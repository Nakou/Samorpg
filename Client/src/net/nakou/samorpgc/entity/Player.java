/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.nakou.samorpgc.entity;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author abo
 */
public class Player extends Entity{
    
    public Player(String n, int hpMax, Color color){
	super(n,hpMax,color);
    }
    
    public void drawPlayer(Graphics g){
	g.setColor(Color.white);
	g.drawString(name, x-5, y+45);
	g.setColor(this.color);
	g.fillRect(x, y, 30, 30);
	g.setColor(Color.ORANGE);
	g.fillRect(x+10, y+10, 10, 10);
    }
    
    
}
