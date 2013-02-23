/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.nakou.samorpgc.gamestates;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import net.nakou.samorpgc.gameengine.Samorpg;

/**
 *
 * @author Nakou
 */
public class ConnectState extends AbstractState{
    private int x = 0;
    private int y = 0;
    public ConnectState(Samorpg f, String n){
	super(f,n);
	this.setFocusable(true);
	this.addKeyListener(new Inputs());
    }
    public ConnectState(){
	super();
    }

    @Override
    public void update(){
	super.update();
	x+=1;
	y+=1;
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
	this.setBackground(Color.black);
	//Dimension d = this.getPreferredSize();
	g2.setFont(new Font("Arial", Font.PLAIN, 80));
	g2.setColor(Color.white);
	g2.drawString("Samo RPG", 200, 200);
	g2.setFont(new Font("Arial", Font.PLAIN, 15));
	g2.setColor(Color.white);
	g2.drawString("The Simpliest Online RPG You Ever Seen", 200, 230);
	g2.setColor(Color.red);
	g2.fillRect(x, y, x, y);
	//System.out.println("Draw!");
    }*/
    
    /* WITH SWING    */
    @Override
    public void paintComponent(Graphics g){
	Graphics2D g2 = (Graphics2D) g;
	RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
	
	rh.put(RenderingHints.KEY_RENDERING, 
		RenderingHints.VALUE_RENDER_QUALITY);
	
	g2.setRenderingHints(rh);
	g2.setColor(Color.black);
	g2.fillRect(0, 0, frame.WIDTH, frame.HEIGHT);
	//Dimension d = this.getPreferredSize();
	g2.setFont(new Font("Arial", Font.PLAIN, 80));
	g2.setColor(Color.white);
	g2.drawString("Samo RPG", 200, 200);
	g2.setFont(new Font("Arial", Font.PLAIN, 15));
	g2.setColor(Color.white);
	g2.drawString("The Simpliest Online RPG You Ever Seen", 200, 230);
	g2.setColor(Color.red);
	g2.fillRect(x, y, x, y);
	//System.out.println("Draw!");
    }

    public class Inputs extends KeyAdapter{
	public boolean chat = false;

	/*public void keyPressed(KeyEvent e) {
	    int key = e.getKeyCode();
	    if(actualState.toString().equals("ConnectState")){
		this.inputConnectState(key);
	    } else if(actualState.toString().equals("InGameState")){
		this.inputInGameState(key);
	    }
	}*/

	public void keyPressed(KeyEvent e){
	    int key = e.getKeyCode();
	    inputConnectState(key);
	}
	
	public void inputConnectState(int key){
	    if(key == KeyEvent.VK_A){
		System.out.println("Yaha!");
		callState = "ConnectedState";
	    }
	    if (key == KeyEvent.VK_ESCAPE) {
		System.exit(0);
	    }
	}

	/*public void inputInGameState(int key){
	    if(!chat){
		if (key == KeyEvent.VK_UP) {
		    System.out.println("Up!");
		}
		if (key == KeyEvent.VK_DOWN) {
		    System.out.println("Down!");
		}
		if (key == KeyEvent.VK_LEFT) {
		    System.out.println("Left!");
		}
		if (key == KeyEvent.VK_RIGHT) {
		    System.out.println("Right!");
		}
		if (key == KeyEvent.VK_ENTER) {
		    chat = true;
		    System.out.println("Enter Chat Mode!");
		}
	    } else {
		if (key == KeyEvent.VK_ENTER) {
		    chat = false;
		    System.out.println("Quit Chat Mode!");
		}
	    }
	}*/
    }
    
}
