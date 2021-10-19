package hw002.house.room;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Floor implements Heatable {

    private static final Logger LOGGER = LogManager.getLogger(Floor.class);

    private String material;
    private Boolean isHeated;

    public Floor(String material, Boolean isHeated) {
        this.material = material;
        this.isHeated = isHeated;
    }

    @Override
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Floor floor = (Floor) o;
        return Objects.equals(material, floor.material) && Objects.equals(isHeated, floor.isHeated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(material, isHeated);
    }
}
