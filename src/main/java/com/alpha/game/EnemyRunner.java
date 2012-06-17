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
			
			for(int i = 0; i < Runnable.enemies.size(); i++) {
				Runnable.enemies.elementAt(i).run();
			}
		}
	}
	
	static void draw() {
		for(int i = 0; i < Runnable.enemies.size(); i++) {
			Runnable.enemies.elementAt(i).draw(Statics.g2d);
		}
	}
}