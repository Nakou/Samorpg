/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.nakou.samorpgc.gameengine;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import net.nakou.samorpgc.gamestates.AbstractState;

/**
 *
 * @author Nakou
 *//*
public class Inputs extends KeyAdapter{
    public AbstractState actualState;
    public boolean chat = false;
    
    public void keyPressed(KeyEvent e) {
	int key = e.getKeyCode();
	if(this.actualState.toString().equals("ConnectState")){
	    this.inputConnectState(key);
	} else if(this.actualState.toString().equals("InGameState")){
	    this.inputInGameState(key);
	}
    }
    
    public void inputConnectState(int key){
	if(key == KeyEvent.VK_A){
	    System.out.println("Yaha!");
	}
	if (key == KeyEvent.VK_ESCAPE) {
	    System.exit(0);
	}
    }
    
    public void inputInGameState(int key){
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
    }
    
    public void setActualState(AbstractState s){
	this.actualState = s;
    }
    
}*/
