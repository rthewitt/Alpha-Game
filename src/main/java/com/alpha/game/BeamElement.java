package com.alpha.game;

import java.awt.Graphics2D;
import java.util.Vector;

public class BeamElement extends Thread {
	static Vector<BeamElement> beams = new Vector<BeamElement>();
	boolean beamsRunning = true;
	int Counter;
	
	//Type of beams
	SingleBeam sb;
	DualBeam db;
	WaveBeam wb;
	PiercingBeam pb;
	ExplodingBeam exb;
	ShotgunBeam shb;
	MachgunBeam mb;
	LaserBeam lb;
	
	BeamElement() {
		
	}
	
	public void newBeam() {
		switch(GameState.beamType) {
			case 0: sb = new SingleBeam(); beams.addElement(sb); break;
			
			case 1: db = new DualBeam(); beams.addElement(db); break;
	
			case 2: pb = new PiercingBeam(); beams.addElement(pb); break;
			
			case 3: exb = new ExplodingBeam(); beams.addElement(exb); break;
			
			case 4: lb = new LaserBeam(); beams.addElement(lb); break;
			
			case 5: wb = new WaveBeam(); beams.addElement(wb); break;
			
			case 6: shb = new ShotgunBeam(); beams.addElement(shb); break;
	
			case 7: mb = new MachgunBeam(); beams.addElement(mb); break;
		}
	}
	
	static void addMe(BeamElement be) {
		beams.addElement(be);
	}
	
	public int getX() {
		return 0;
		
	}
	
	public int getY() {
		return 0;
	}
	
	public double getDamage() {
		return 0;
		
	}
	
	void kill() {
		
	}
	
	public void run() {
		while(beamsRunning) {
				try {
					Thread.sleep(3);
	           	}
				catch (InterruptedException e) {
					System.out.println("Woke up prematurely");
				}
				
			if(GameState.pause == false) {
				for(int i = 0; i < beams.size(); i++) {
					beams.elementAt(i).run();
				}
			}
		}
	}

	void draw(Graphics2D g2d) {
		for(int i = 0; i < beams.size(); i++) {
			beams.elementAt(i).draw(g2d);
		}
	}
}
