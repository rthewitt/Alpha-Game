package com.alpha.game.ships;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import com.alpha.game.MovableEntity;

public abstract class ShipEntity extends MovableEntity {
	
	public static ShipEntity currentShip;
	public static ImageIcon hullShip;
	public static ImageIcon nextShip;
	
	public abstract int getWidth();
	public abstract int getHeight();
	public abstract BufferedImage getImage();
	public abstract double percentLeft();
	public abstract int getSpeed();
	public abstract double getDamage();
	public abstract int getHealth();
	public abstract void setX(int x);
	public abstract void setY(int y);
	public abstract void fire();
	public abstract int getX();
	public abstract int getY();
	public abstract void kill();
	public abstract void update();
	public abstract void draw(Graphics2D g2d);
}
