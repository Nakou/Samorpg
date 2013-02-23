/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.nakou.samorpgc.gameengine;

import java.awt.*;
import javax.swing.JPanel;
import net.nakou.samorpgc.entity.Player;
import net.nakou.samorpgc.socketsmanager.SocketLink;

/**
 *
 * @author Nakou
 */
public class FramePanel extends JPanel{

    private SocketLink skt;
    private boolean inPause;
    private String state;
    private float delta;
    private float time;
    
    public FramePanel(){
	this.setBackground(Color.black);
    }
    
    @Override
    public void paint(Graphics g){
	
	Graphics2D g2 = (Graphics2D) g;
	RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
	
	rh.put(RenderingHints.KEY_RENDERING, 
		RenderingHints.VALUE_RENDER_QUALITY);
	
	g2.setRenderingHints(rh);
	
	Player p = new Player("Nakou",10,Color.blue);
	p.setX(100);
	p.setY(100);
	p.drawPlayer(g2);

    }
    
}
