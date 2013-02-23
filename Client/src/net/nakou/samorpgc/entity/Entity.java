/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.nakou.samorpgc.entity;

import java.awt.Color;

/**
 *
 * @author abo
 */
public abstract class Entity {
    protected String name;
    protected int healtPointsMax;
    protected int healtPoints;
    protected int level;
    protected boolean dead;
    protected int x;
    protected int y;
    protected Color color;
    
    public Entity(String n, int hpmax,Color color){
	this.name = n;
	this.healtPointsMax = hpmax;
	this.healtPoints = hpmax;
	this.level = 1;
	this.dead = false;
	this.color = color;
    }
    
    public void getDamages(int howMuch){
	healtPoints -= howMuch;
	if(healtPoints <= 0)
	    dead = true;
	else
	    dead = false;
    }
    
    /*public abstract 
    */
    /* GETTETS */
    public boolean isDead() {
	return dead;
    }

    public int getHealtPointsMax() {
	return healtPointsMax;
    }    
    
    public int getHealtPoints() {
	return healtPoints;
    }

    public int getLevel() {
	return level;
    }

    public String getName() {
	return name;
    }


    /* SETTERS */
    public void setDead(boolean dead) {
	this.dead = dead;
    }

    public void setHealtPointsMax(int healtPoints) {
	this.healtPointsMax = healtPoints;
    }    
    
    public void setHealtPoints(int healtPoints) {
	this.healtPoints = healtPoints;
    }

    public void setLevel(int level) {
	this.level = level;
    }

    public void setName(String name) {
	this.name = name;
    }

    public int getX() {
	return x;
    }

    public int getY() {
	return y;
    }

    public void setX(int x) {
	this.x = x;
    }

    public void setY(int y) {
	this.y = y;
    }

    public Color getColor() {
	return color;
    }

    public void setColor(Color color) {
	this.color = color;
    }
}
