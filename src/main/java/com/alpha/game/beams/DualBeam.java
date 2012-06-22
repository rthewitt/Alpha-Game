package com.alpha.game.beams;

import java.awt.Graphics2D;

import com.alpha.game.MovableEntity;

public class DualBeam extends BeamEntity {
	
	public DualBeam(int x, int y) {
		MovableEntity m = new SingleBeam(x - 3, y);
		beams.add(m);
		m = new SingleBeam(x + 3, y);
		beams.add(m);
		kill();
	}
	
	public void update() {
	}
	
	public double getDamage() {
		return 0;
	}
	
	public void kill() {
		beams.remove(this);
	}

	public void draw(Graphics2D g2d) {
	}

	double getReload() {
		return 0;
	}
}