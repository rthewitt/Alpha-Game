package com.alpha.game.beams;

import java.awt.Graphics2D;

import com.alpha.game.MovableEntity;

public abstract class BeamEntity extends MovableEntity {
	
	abstract double getReload();
	
	abstract public int getX();
	abstract public int getY();
	abstract public void kill();
	abstract public void update();
	abstract public void draw(Graphics2D g2d);
}
