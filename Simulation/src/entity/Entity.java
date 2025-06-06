package entity;

import simulation.GameMap;
import java.awt.*;

public abstract class Entity {

    protected GameMap map;
    public Point point;

    public Entity(Point point, GameMap map) {
        this.point = point;
        this.map = map;
    }

    public abstract String getSprite();

}
