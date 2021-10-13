package hw002.company.construction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class ColorFloor extends Floor {

    private static final Logger LOGGER = LogManager.getLogger(ColorFloor.class);

    private String color;

    public ColorFloor(String floorType, Boolean hasHeater, String color) {
        super(floorType, hasHeater);
        this.color = color;
    }

    @Override
    public abstract void floreInstalling();

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
