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
			
			if(GameState.pause == false)
			for(int i = 0; i < MovableEntity.enemies.size(); i++) {
				MovableEntity.enemies.elementAt(i).update();
			}
		}
	}
	
	static void draw() {
		for(int i = 0; i < MovableEntity.enemies.size(); i++) {
			MovableEntity.enemies.elementAt(i).draw(GameState.g2d);
		}
	}
}