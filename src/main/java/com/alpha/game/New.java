package com.alpha.game;

import com.alpha.game.beams.DualBeam;
import com.alpha.game.beams.ExplodingBeam;
import com.alpha.game.beams.LaserBeam;
import com.alpha.game.beams.MachgunBeam;
import com.alpha.game.beams.PiercingBeam;
import com.alpha.game.beams.ShotgunBeam;
import com.alpha.game.beams.SingleBeam;
import com.alpha.game.beams.WaveBeam;
import com.alpha.game.enemies.BigYellow;
import com.alpha.game.enemies.BlueFighter;
import com.alpha.game.enemies.BlueHeavy;
import com.alpha.game.enemies.BossOne;
import com.alpha.game.enemies.MedYellow;
import com.alpha.game.enemies.RedFighter;
import com.alpha.game.enemies.RedHeavy;

public class New {
	
	MovableEntity r;
	
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
		MovableEntity.beams.addElement(r);
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
		MovableEntity.enemies.addElement(r);
	}
	
	void newShip() {
		Ship s = new Ship();
		MovableEntity.ships.addElement(s);
	}
}
