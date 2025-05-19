package entity;

import simulation.GameMap;
import java.awt.*;

public class Tree extends Entity{

    public Tree(Point point, GameMap map) {
        super(point, map);
    }

    @Override
    public String getSprite() {
        return "\u001B[38;5;22m" + "\uD83C\uDF34" + "\u001B[0m";
    }
}
