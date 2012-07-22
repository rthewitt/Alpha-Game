package com.alpha.game;

import com.alpha.game.beams.*;
import com.alpha.game.enemies.*;
import com.alpha.game.ships.*;

public class Factory {
	
	static MovableEntity r;
	private static BeamEntity b;
	
	private static void newBeam(int x, int y, int type, boolean yourBeam) {
		switch(type) {
		case 0: r = new SingleBeam(x, y, yourBeam); break;
		
		case 1: r = new DualBeam(x, y, yourBeam); break;

		case 2: r = new PiercingBeam(x, y, yourBeam); break;
		
		case 3: r = new ExplodingBeam(x, y, yourBeam); break;
		
		case 4: r = new LaserBeam(x, y, yourBeam); break;
		
		case 5: r = new WaveBeam(x, y, yourBeam); break;
		
		case 6: r = new ShotgunBeam(x, y, yourBeam); break;

		case 7: r = new MachgunBeam(x, y, yourBeam); break;
		}
		
		MovableEntity.beams.addElement(r);
		if(yourBeam)
			b = (BeamEntity) r;
	}
	
	public static void newEnemyBeam(int x, int y, int type){
		newBeam(x, y, type, false);
	}
	
	public static void newShipBeam(int x, int y, int type) {
		newBeam(x, y, type, true);
	}
	
	static BeamEntity getCurrentBeam() {
		return b;
	}
	
	static void newEnemy(int type) {
		switch(type) {
		case 1: r = new RedFighter(); break;
		
		case 2: r = new RedHeavy(); break;
		
		case 3: r = new BlueFighter(); break;
		
		case 4: r = new BlueHeavy(); break;
		
		case 5: r = new MedYellow(); break;
		
		case 6: r = new BigYellow(); break;
		
		case 7: r = new BossOne(); break;
		}
		MovableEntity.enemies.addElement(r);
	}
	
	static void newShip(int type) {
		int x = 250, y = 600;
		switch(type) {
		case 1: r = new SmallGreen(x, y); break;
		
		case 2: r = new MedGreen(x, y); break;
		
		case 3: r = new LargeGreen(x, y); break;
		
		case 4: r = new SmallRed(x, y); break;
		
		case 5: r = new MedRed(x, y); break;
		
		case 6: r = new LargeRed(x, y); break;
		
		case 7: r = new SmallBlue(x, y); break;
		
		case 8: r = new MedBlue(x, y); break;
		
		case 9: r = new LargeBlue(x, y); break;
		}
		MovableEntity.ships.addElement(r);
	}
	
	//Example of what I have in mind for level options
	static void newNormalLevel(int lvl) {
		new BuildLevel().newLevel(lvl);
	}
	
	static void newSlowModeLevel(int lvl) {
		//speedModifier = 2
		new BuildLevel().newLevel(lvl);
	}
	
	static void newHardModeLevel(int lvl) {
		//EnemieDamageModifier += 1.5
		//EnemieSpeedModifier += 1
		//EnemieHealthModifier = 2
		new BuildLevel().newLevel(lvl);
	}
	
	static void newImpossibleLevel(int lvl) {
		//EnemieDamageModifier += 2
		//EnemieSpeedModifier += 2
		//EnemieHealthModifier = 4
		new BuildLevel().newLevel(lvl);
	}
}