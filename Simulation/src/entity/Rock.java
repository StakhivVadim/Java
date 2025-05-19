package entity;

import simulation.GameMap;

import java.awt.*;

public class Rock extends Entity {

    public Rock(Point point, GameMap map) {
        super(point, map);
    }

    @Override
    public String getSprite() {
    	return "\u001B[38;5;240m" + "\uD83D\uDDFF" + "\u001B[0m";
    }
}
