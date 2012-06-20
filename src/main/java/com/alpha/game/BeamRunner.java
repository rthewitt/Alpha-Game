package com.alpha.game;

class BeamRunner extends Thread{
	boolean running = true;
	
	BeamRunner() {
		this.start();
	}
	
	public void run() {
		while(running) {
			try {
				Thread.sleep(Statics.bulletSpeed);
			}catch (InterruptedException e) {
				System.out.println("Woke up prematurely");
			}
			
			if(Statics.pause == false)
			for(int i = 0; i < MovableEntity.beams.size(); i++) {
				MovableEntity.beams.elementAt(i).update();
			}
		}
	}
	
	static void draw() {
		for(int i = 0; i < MovableEntity.beams.size(); i++) {
			MovableEntity.beams.elementAt(i).draw(Statics.g2d);
		}
	}
}