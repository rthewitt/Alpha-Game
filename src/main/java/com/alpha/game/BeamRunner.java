package com.alpha.game;

class BeamRunner extends Thread{
	boolean running = true;
	
	BeamRunner() {
		this.start();
	}
	
	public void run() {
		while(running) {
			try {
				Thread.sleep(3);
			}catch (InterruptedException e) {
				System.out.println("Woke up prematurely");
			}
			
			for(int i = 0; i < Runnable.beams.size(); i++) {
				Runnable.beams.elementAt(i).run();
			}
		}
	}
	
	static void draw() {
		for(int i = 0; i < Runnable.beams.size(); i++) {
			Runnable.beams.elementAt(i).draw(Statics.g2d);
		}
	}
}