package com.alpha.game;

public class UpgradeMenuAnimation extends Thread {
	
	public void go() {
		start();
	}
	
	public void run(){
		while(true) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(UpgradeMenu.rectSize < 180) {
				UpgradeMenu.rectSize ++;
			}
			
			if(UpgradeMenu.rowHeight < 550) {
				UpgradeMenu.rowHeight ++;
			}
			
			if(UpgradeMenu.rectSize == 180 && UpgradeMenu.rowHeight == 550)
				kill();
		}
	}
	
	@SuppressWarnings("deprecation")
	private void kill() {
		UpgradeMenu.animationDone = true;
		this.stop();
	}
}
