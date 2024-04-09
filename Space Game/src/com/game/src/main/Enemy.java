package com.game.src.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.game.scr.main.classes.EntityB;

public class Enemy extends GameObject implements EntityB{
	
	
	Random r = new Random();
	
	private Textures tex;
	
	public Enemy(double x, double y, Textures tex) {
		super(x, y);
		this.tex = tex;
	}
	
	public void tick() {
		y += 5;
		if(y > (Game.HEIGHT * Game.SCALE)) {
			y = -10;
			x = r.nextInt(Game.WIDTH * Game.SCALE);
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(tex.enemy, (int)x, (int)y, null);
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
	}
	
	public double getY() {
		return y;
	}

	
	public double getX() {
		return x;
	}
}
