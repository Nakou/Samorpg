/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.nakou.samorpgs.main;

import java.awt.Color;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abo
 */
public class Player implements Runnable {
    private Server server;
    private ServerSocket socketServ;
    private Socket sock;
    private String pseudo;
    private int x;
    private int y;
    private DataInputStream  streamIn  =  null;
    private DataOutputStream streamOut = null;
    
    public Player(ServerSocket ss, Server srv){
	socketServ = ss;
	server = srv;
    }
    
    @Override
    public void run()
    {   
	try {
	    streamIn = new DataInputStream(sock.getInputStream());
	    pseudo = streamIn.readUTF();
	    System.out.println("Connection of " + pseudo + "!");
	    server.add(this);
	} catch (IOException ex) {
	    System.out.println("Pseudo Emission Error");
	}
	while (true){  
	    try {
		server.handle(streamIn,pseudo);
		System.out.println("Connection fail for "+pseudo+". Socket closed");
		close();
		server.remove(this);
	    } catch (IOException ex) {
		Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
    }
    
    public void open() throws IOException
    {  
	streamIn = new DataInputStream(new 
			BufferedInputStream(sock.getInputStream()));
	streamOut = new DataOutputStream(new
			BufferedOutputStream(sock.getOutputStream()));
    }
    public void close() throws IOException
    {  
	if (sock != null)    sock.close();
	if (streamIn != null)  streamIn.close();
	if (streamOut != null) streamOut.close();
    }

    public String getPseudo() {
	return pseudo;
    }

    public void setPseudo(String pseudo) {
	this.pseudo = pseudo;
    }

    public Server getServer() {
	return server;
    }

    public void setServer(Server server) {
	this.server = server;
    }

    public Socket getSock() {
	return sock;
    }

    public void setSock(Socket sock) {
	this.sock = sock;
    }

    public ServerSocket getSocketServ() {
	return socketServ;
    }

    public void setSocketServ(ServerSocket socketServ) {
	this.socketServ = socketServ;
    }

    public DataInputStream getStreamIn() {
	return streamIn;
    }

    public void setStreamIn(DataInputStream streamIn) {
	this.streamIn = streamIn;
    }

    public DataOutputStream getStreamOut() {
	return streamOut;
    }

    public void setStreamOut(DataOutputStream streamOut) {
	this.streamOut = streamOut;
    }

    public int getX() {
	return x;
    }

    public void setX(int x) {
	this.x = x;
    }

    public int getY() {
	return y;
    }

    public void setY(int y) {
	this.y = y;
    }
    
    
}
