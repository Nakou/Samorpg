/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.nakou.samorpgc.gameengine;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import net.nakou.samorpgc.socketsmanager.SocketLink;
import net.nakou.samorpgc.gamestates.*;

/**
 *
 * @author abo
 */
public final class Samorpg extends JFrame{
    public static int WIDTH = 800;
    public static int HEIGHT = 600;
    //private Inputs inputManager;
    private SocketLink skt;
    private boolean inPause;
    private float delta;
    private float time;
    private ArrayList<AbstractState> states;
    private AbstractState actualState;
    /*Samorpg INDEV0.0.1*/

    public Samorpg(){
	this.setTitle("Samorpg INDEV0.0.1");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // WITH SWING
	/* WITH AWT
	 this.addWindowListener(new WindowAdapter(){
	  public void windowClosing(WindowEvent we){
	    System.exit(0);
	  }}); */
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
	this.setVisible(true);
	this.myInputInit();
	this.statesInit();
	this.initGame();
	this.masterUpdate();
    } 
    
    public void myInputInit(){
	/*this.inputManager = new Inputs();
	this.addKeyListener(this.inputManager);	*/
    }
    
    public void statesInit(){
	this.states = new ArrayList<AbstractState>();
	this.states.add(new ConnectState(this, "ConnectState"));
	this.states.get(0).setActive(true);
	this.states.add(new ConnectedState(this, "ConnectedState"));
    }
    

    private void initGame() {
	this.actualState = this.states.get(0);
    }
        
    public void networkInit(){
	
    }
    
    public void masterUpdate(){
	this.add(this.actualState);
	AbstractState stateAtStart;
	while(true){
	    stateAtStart = this.actualState;
	    /* WE CHECK IF THE STATE AS CHANGE */
	    for(AbstractState s : this.states){
		if(s.getActive())
		    if(s != this.actualState){
			this.actualState = s;
		    }		    
	    }
	    /* WE CHECK IF THE STATE IS NULL*/
	    if(this.actualState == null){
		System.out.println("FATAL : NO STATE REFERENCED!");
		System.exit(0);
	    } else { /* WE CAN CALL THE CONCERNED UPDATE AND ATTACH THE PANE TO THE FRAME */
		if(this.actualState != stateAtStart ){
		    this.remove(stateAtStart);
		    this.add(this.actualState);
		    this.revalidate();
		    this.repaint();
		    this.actualState.requestFocus();
		}
		//this.actualState.revalidate();
		this.actualState.repaint();
		this.actualState.update();
	    }
	    //System.gc();
	}
    }   
    
    /* GETTERS SETTERS */

    public AbstractState getActualState() {
	return actualState;
    }

    public void setActualState(AbstractState actualState) {
	this.actualState = actualState;
    }

    public float getDelta() {
	return delta;
    }

    public void setDelta(float delta) {
	this.delta = delta;
    }

    public boolean isInPause() {
	return inPause;
    }

    public void setInPause(boolean inPause) {
	this.inPause = inPause;
    }

    public SocketLink getSkt() {
	return skt;
    }

    public void setSkt(SocketLink skt) {
	this.skt = skt;
    }

    public ArrayList<AbstractState> getStates() {
	return states;
    }

    public void setStates(ArrayList<AbstractState> states) {
	this.states = states;
    }

    public float getTime() {
	return time;
    }

    public void setTime(float time) {
	this.time = time;
    }


   
}
