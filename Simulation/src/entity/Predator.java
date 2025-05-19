package entity;

import simulation.GameMap;
import java.awt.*;

public class Predator extends Creature {

    public Predator(Point point, GameMap map) {
        super(point, map);
        speed = 4;
        hp = 10;
        attackPower = 5;
    }

    @Override
    protected Class<? extends Entity> getTargetType() {
        return Herbivore.class;
    }

    @Override
    public String getSprite() {
    	return "\u001B[38;5;208m" + "\uD83D\uDC05" + "\u001B[0m";
    }

    protected void attack(Point targetPoint, int attackPower) {
        Herbivore herbivore = (Herbivore) map.getEntityByPoint(targetPoint);
        herbivore.takeDamage(attackPower);
        if (herbivore.hp < 0) {
            herbivore.isAlive = false;
            map.removeEntity(targetPoint);
            map.moveEntity(targetPoint, this);
        }
    }
}
