package entity;

import simulation.GameMap;
import java.awt.*;

public class Grass extends Entity {
    int hp;

    public Grass(Point point, GameMap map) {
        super(point, map);
        hp = 10;
    }

    public void takeDamage(int damage) {
        hp -= damage;
    }

    @Override
    public String getSprite() {
        return "\u001B[38;5;120m" + "\uD83C\uDF3C" + "\u001B[0m";
    }
}
