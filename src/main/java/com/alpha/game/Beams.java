package com.alpha.game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class Beams {
	protected static List<Beam> beams = new ArrayList<Beam>();
	private static Beam lastFired;
	
	private class Beam {
		double x, y;
		double speed;
		long reload;
		boolean down;
		double damage;
		BufferedImage using;
	}
	
	public Beams(double X, double Y, double s, boolean b, long r, double d, BufferedImage bi) {
		Beam beam = new Beam();
		beam.x = X;
		beam.y = Y;
		beam.speed = s;
		beam.down = b;
		beam.reload = r;
		beam.damage = d;
		beam.using = bi;
		lastFired = beam;
		beams.add(beam);
	}

	public static void update() {
		for(Beam b : beams) {
			if(b.down) {
				b.y -= b.speed;
				
				if(b.y < 0 || Enemies.testMe(b.x, b.y, b.damage))
					kill(b);
			} else {
				b.y += b.speed;
				
				if(b.y > Frame.height || Ship.testShip(b.x, b.y, b.damage))
					kill(b);
			}
		}
	}
	
	public static void kill(Beam b) {
		beams.remove(b);
	}

	public static void draw(Graphics2D g2d) {
		try {
			for(Beam b : beams)
				g2d.drawImage(b.using, (int)b.x - b.using.getWidth()/2, (int)b.y, null);
		} catch (ConcurrentModificationException e) {}
	}

	public static long getReload() {
		return lastFired.reload;
	}
}