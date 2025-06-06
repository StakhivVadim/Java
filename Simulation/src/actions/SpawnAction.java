package actions;

import entity.Entity;
import simulation.GameMap;

import java.awt.*;
import java.util.Random;

public abstract class SpawnAction<T extends Entity> extends Action {
    protected double rate;

    public SpawnAction(GameMap map) {
        super(map);
    }

    @Override
    public boolean perform() {
        int currentRate = 0;
        while (currentRate < rate){
            Point point = getEmptyRandomPoint();
            map.setEntity(point, spawnEntity(point));
            currentRate++;
        }
        return false;
    }

    protected Point getEmptyRandomPoint() {
        Random r = new Random();
        while (true) {
            int x = r.nextInt(map.getWidth());
            int y = r.nextInt(map.getHeight());
            Point point = new Point(x, y);
            if (!map.isPointHaveEntity(point)){
                return point;
            }
        }
    }

    protected abstract T spawnEntity(Point point);

}
