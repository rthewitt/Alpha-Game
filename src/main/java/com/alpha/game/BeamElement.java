package com.alpha.game;

import java.awt.Graphics2D;
import java.util.Vector;

public class BeamElement extends Thread {
	static Vector<BeamElement> beams = new Vector<BeamElement>();
	Game game;
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
	PoisonBeam eb;
	
	BeamElement() {
		game = GameState.game;
	}
	
	public void newBeam() {
		switch(GameState.beamType) {
			case 0: sb = new SingleBeam(); beams.addElement(sb);
			
			case 1: db = new DualBeam(); beams.addElement(db);
	
			case 2: wb = new WaveBeam(); beams.addElement(wb);
	
			case 3: pb = new PiercingBeam(); beams.addElement(pb);
			
			case 4: exb = new ExplodingBeam(); beams.addElement(exb);
	
			case 5: shb = new ShotgunBeam(); beams.addElement(shb);
	
			case 6: mb = new MachgunBeam(); beams.addElement(mb);
	
			case 7: eb = new PoisonBeam(); beams.addElement(eb);
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
			
			for(int i = 0; i < beams.size(); i++) {
				beams.elementAt(i).run();
			}
		}
	}

	void draw(Graphics2D g2d) {
		for(int i = 0; i < beams.size(); i++) {
			beams.elementAt(i).draw(g2d);
		}
	}
}
