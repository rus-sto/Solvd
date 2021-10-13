package hw002.company.material;


import hw002.company.construction.ColorFloor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class FloorSquare extends ColorFloor {

    private static final Logger LOGGER = LogManager.getLogger(FloorSquare.class);

    private Wall[] walls;

    public FloorSquare(String floorType, Boolean hasHeater, String color, Wall[] walls) {
        super(floorType, hasHeater, color);
        this.walls = walls;
    }

    public int countWalls(Wall[] walls) {
        int count = walls.length;
        return count;
    }

    public double floorSquareCalc(Wall[] walls, int countWalls) {
        double floorSquare = 0;
        switch (countWalls) {
            case 1:
                floorSquare = 3.14 * walls[0].getLength() * walls[0].getLength() / 6.28 * 6 / 28;
                break;
            case 2:
                floorSquare = walls[0].getLength() * walls[1].getLength() * 0.3;
                break;
            case 3:
                floorSquare = walls[0].getLength() * walls[1].getLength() * walls[2].getLength() * 0.25;
                break;
            case 4:
                floorSquare = (walls[0].getLength() * walls[1].getLength() + walls[2].getLength() * walls[3].getLength()) * 0.5;
                break;
            case 5:
                floorSquare = walls[0].getLength() * walls[1].getLength() * walls[2].getLength() * walls[3].getLength() * walls[4].getLength() * 0.05;
                break;
            default:
                floorSquare = 0;
                break;
        }
        return floorSquare;
    }

    @Override
    public void floreInstalling() {
        LOGGER.debug("The best Floor has been installed!");
    }

    public Wall[] getWalls() {
        return walls;
    }

    public void setWalls(Wall[] walls) {
        this.walls = walls;
    }

    @Override
    public String toString() {
        return "FloorSquare{" +
                "walls=" + Arrays.toString(walls) +
                '}';
    }
}
