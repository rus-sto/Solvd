package hw002.house.sostav;

import hw002.house.exception.ElementHeightException;
import hw002.house.exception.MaterialInvalidException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Element {

    private static final Logger LOGGER = LogManager.getLogger(Element.class);

    private double length;
    private double height;
    private String material;

    public Element() {
    }

    public Element(double length, double height, String material) {
        this.length = length;
        if (height < 0.1 || height > 5) {
            throw new ElementHeightException("Impossible height");
        }
        this.height = height;
        if (material.contains("_")) {
            throw new MaterialInvalidException("Material is invalid");
        }
        this.material = material;
    }

    public void printMaterialInfo() {
        LOGGER.debug(" this material is " + material + " It's length and height  are - " + length + " - " + height);
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height < 0.1 || height > 5) {
            throw new ElementHeightException("Impossible height");
        }
        this.height = height;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        if (material.contains("_")) {
            throw new MaterialInvalidException("Material is invalid");
        }
        this.material = material;
    }

    @Override
    public String toString() {
        return "Element{" +
                "length=" + length +
                ", height=" + height +
                ", material='" + material + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return Double.compare(element.length, length) == 0 && Double.compare(element.height, height) == 0 && Objects.equals(material, element.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, height, material);
    }
}