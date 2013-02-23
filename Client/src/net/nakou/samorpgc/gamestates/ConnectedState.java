/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.nakou.samorpgc.gamestates;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import net.nakou.samorpgc.gameengine.Samorpg;

/**
 *
 * @author Nakou
 */
public class ConnectedState extends AbstractState{
    
    public ConnectedState(Samorpg f, String n){
	super(f,n);
	this.setFocusable(true);
	this.addKeyListener(new Inputs());
    }
    public ConnectedState(){
	super();
    }

    @Override
    public void update(){
	super.update();
   }
    /* WITH AWT 
    @Override
    public void paint(Graphics g){
	Graphics2D g2 = (Graphics2D) g;
	RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
	
	rh.put(RenderingHints.KEY_RENDERING, 
		RenderingHints.VALUE_RENDER_QUALITY);
	
	g2.setRenderingHints(rh);
	this.setBackground(Color.red);
	g2.setColor(Color.white);
	g2.drawString("ConnectedState", 10, 10);
    }*/
    
    /*WITH SWING*/
    @Override
    public void paintComponent(Graphics g){
	Graphics2D g2 = (Graphics2D) g;
	RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
	
	rh.put(RenderingHints.KEY_RENDERING, 
		RenderingHints.VALUE_RENDER_QUALITY);
	
	g2.setRenderingHints(rh);
	g2.setColor(Color.red);
	g2.fillRect(0, 0, frame.WIDTH, frame.HEIGHT);
	g2.setColor(Color.white);
	g2.drawString("ConnectedState", 10, 10);
    }

    public class Inputs extends KeyAdapter{

	public void keyPressed(KeyEvent e){
	    int key = e.getKeyCode();
	    inputConnectState(key);
	}
	
	public void inputConnectState(int key){
	    if(key == KeyEvent.VK_A){
		System.out.println("Youpi!");
		callState = "ConnectState";
	    }
	    if (key == KeyEvent.VK_ESCAPE) {
		System.exit(0);
	    }
	}
    }
    
}
