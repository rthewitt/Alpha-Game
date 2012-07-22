package com.alpha.game.beams;

import java.awt.Graphics2D;

public class DualBeam extends BeamEntity {
	
	private final long RELOAD = 400;
	
	public DualBeam() {
		
	}
	
	public DualBeam(int x, int y, boolean b) {
		beams.add(new SingleBeam(x - 5, y, b));
		beams.add(new SingleBeam(x + 5, y, b));
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

	public long getReload() {
		return RELOAD;
	}
}