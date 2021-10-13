package hw002.house.room;

import hw002.house.House002;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Floor {

    private static final Logger LOGGER = LogManager.getLogger(Floor.class);

    private String material;
    private Boolean isHeated;

    public Floor(String material, Boolean isHeated) {
        this.material = material;
        this.isHeated = isHeated;
    }

    public void turnOn() {
        if (isHeated) {
            LOGGER.debug("heater is on");
        } else {
            LOGGER.debug("no heater on this floor");
        }
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Boolean getHeated() {
        return isHeated;
    }

    public void setHeated(Boolean heated) {
        isHeated = heated;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "material='" + material + '\'' +
                ", isHeated=" + isHeated +
                '}';
    }
}
