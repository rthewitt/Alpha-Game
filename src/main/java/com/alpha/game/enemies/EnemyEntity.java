package com.alpha.game.enemies;

import java.awt.Graphics2D;
import com.alpha.game.MovableEntity;

public abstract class EnemyEntity extends MovableEntity {
	abstract protected void fire();
	abstract public void kill();
	abstract public void update();
	abstract public void draw(Graphics2D g2d);
}
