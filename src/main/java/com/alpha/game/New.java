package com.alpha.game;

public class New {
	
	Dif r;
	
	void newBeam() {
		switch(Statics.beamType) {
		case 0: r = new SingleBeam(); break;
		
		case 1: r = new DualBeam(); break;

		case 2: r = new PiercingBeam(); break;
		
		case 3: r = new ExplodingBeam(); break;
		
		case 4: r = new LaserBeam(); break;
		
		case 5: r = new WaveBeam(); break;
		
		case 6: r = new ShotgunBeam(); break;

		case 7: r = new MachgunBeam(); break;
		}
		Dif.beams.addElement(r);
	}
	
	void newEnemy(int type) {
		switch(type) {
		case 1: r = new RedFighter(); break;
		
		case 2: r = new RedHeavy(); break;
		
		case 3: r = new BlueFighter(); break;
		
		case 4: r = new BlueHeavy(); break;
		
		case 5: r = new MedYellow(); break;
		
		case 6: r = new BigYellow(); break;
		
		case 7: r = new BossOne(); break;
		}
		Dif.enemies.addElement(r);
	}
	
	void newShip() {
		Ship s = new Ship();
		Dif.ships.addElement(s);
	}
}
