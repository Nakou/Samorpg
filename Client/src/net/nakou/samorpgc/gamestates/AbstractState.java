/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.nakou.samorpgc.gamestates;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.RenderingHints;
import javax.swing.JPanel;
import net.nakou.samorpgc.gameengine.Samorpg;

/**
 *
 * @author Nakou
 */
public abstract class AbstractState extends JPanel{
    protected String callState;
    protected Samorpg frame;
    protected String name;
    protected boolean active;

    public AbstractState(){

    }
    
    public AbstractState(Samorpg f, String n){
	super();
	this.frame = f;
	this.name = n;
	this.active = false;
	this.callState = n;
    }

    public void masterSet(Samorpg f, String n){
	this.frame = f;
	this.name = n;
	this.active = false;
    }
    public void setActive(boolean b){
	this.active = b;
	this.requestFocus(active);
    }
    
    public void update(){
	this.changeToCallState();
    }
    
    public void changeToCallState(){
	if(this.callState != this.name){
	    for(AbstractState s : frame.getStates()){
		if(s.getName().equals(this.callState))
		{
		    System.out.println("CallState :"+this.callState);
		    s.setActive(true);
		    s.setCallState(s.getName());
		}
	    }
	    active = false;
	}
    }
    
    /*WITH SWING */
    @Override 
    public abstract void paintComponent(Graphics g);
   
    /* WITH AWT
    @Override 
    public abstract void paint(Graphics g);
  */
    
    @Override
    public String getName(){
	return this.name;
    }
    
    @Override
    public String toString(){
	return this.name;
    }
    
    public boolean getActive(){
	return this.active;
    }

    public Samorpg getFrame() {
	return frame;
    }

    public void setFrame(Samorpg frame) {
	this.frame = frame;
    }

    public String getCallState() {
	return callState;
    }

    public void setCallState(String callState) {
	this.callState = callState;
    }
    

    
}
