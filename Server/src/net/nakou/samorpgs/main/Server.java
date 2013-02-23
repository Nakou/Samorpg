/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.nakou.samorpgs.main;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import net.nakou.samorpgs.*;

/**
 *
 * @author abo
 */
public class Server{
    private ServerSocket socketServ;
    private ArrayList<Player> con;
    private Thread thread;
    
    public Server() throws IOException{
	con = new ArrayList<Player>();
	socketServ = new ServerSocket(2013);
	thread = new Thread(new Player(socketServ, this));
	thread.start();
    }
    
    void add(Player p) {
	con.add(p);
    }

    void handle(DataInputStream streamIn, String p) throws IOException {
	String s;
	String in = streamIn.readUTF();
	if(!in.isEmpty()){
	    s = in.toCharArray()[0]+""+in.toCharArray()[1];
	    switch(Integer.parseInt(s)){
		case 1:
		    System.out.println("Connection of "+p);
		    break;
		default:
		    System.out.println("Other");
	    }
	} else {
	    
	}
    }

    void remove(Player p) throws IOException {
	con.remove(p);
	p.close();
    }
    
}
