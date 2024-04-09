package com.game.src.main;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.game.scr.main.classes.EntityA;

public class Player extends GameObject implements EntityA {
	
	private double velX = 0;
	private double velY = 0;
	private Textures tex;
	
	public Player(double x, double y, Textures tex) {
		super(x,y);
		this.tex = tex;
	}
	
	public void tick() {
		x+=velX;
		y+=velY;
		
		if(x <= 0)
			x = 0;
		if(x >= Game.WIDTH * Game.SCALE-32)
			x = Game.WIDTH * Game.SCALE-32;
		if(y <= 0)
			y = 0;
		if(y >= Game.HEIGHT * Game.SCALE-32)
			y = Game.HEIGHT * Game.SCALE-32;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
	}
	
	public void render(Graphics g) {
		g.drawImage(tex.player, (int)x, (int)y, null);
	}
	
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	public void setVelX(double velX) {
		this.velX = velX;
	}
	public void setVelY(double velY) {
		this.velY = velY;
	}
}
