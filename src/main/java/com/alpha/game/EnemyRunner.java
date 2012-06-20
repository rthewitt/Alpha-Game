package com.alpha.game;

class EnemyRunner extends Thread{
	boolean running = true;
	
	EnemyRunner() {
		this.start();
	}
	
	public void run() {
		while(running) {
			try {
				Thread.sleep(20);
			}catch (InterruptedException e) {
				System.out.println("Woke up prematurely");
			}
			
			if(Statics.pause == false)
			for(int i = 0; i < Dif.enemies.size(); i++) {
				Dif.enemies.elementAt(i).run();
			}
		}
	}
	
	static void draw() {
		for(int i = 0; i < Dif.enemies.size(); i++) {
			Dif.enemies.elementAt(i).draw(Statics.g2d);
		}
	}
}