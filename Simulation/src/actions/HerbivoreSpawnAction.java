package actions;

import entity.Herbivore;
import simulation.GameMap;
import java.awt.*;

public class HerbivoreSpawnAction extends SpawnAction<Herbivore> {
    public HerbivoreSpawnAction(GameMap map) {
        super(map);
        if (map.getMapSize() > 30){
            rate = map.getMapSize()/30;
        } else {
            rate = 1;
        }
    }

    @Override
    protected Herbivore spawnEntity(Point point) {
        return new Herbivore(point, map);
    }
}
