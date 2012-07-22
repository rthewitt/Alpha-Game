package com.alpha.game.beams;

import java.awt.Graphics2D;
import com.alpha.game.MovableEntity;

public abstract class BeamEntity extends MovableEntity {
	public abstract long getReload();
	
	abstract public void kill();
	abstract public void update();
	abstract public void draw(Graphics2D g2d);
}
