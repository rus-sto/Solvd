package hw002.house.sostav;

import hw002.house.House002;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Wall {

    private static final Logger LOGGER = LogManager.getLogger(Wall.class);

    private Element element;
    private int countElement;


    public Wall(Element element, int countElement) {
        this.element = element;
        this.countElement = countElement;
    }

    public double wallAreaCalc() {
        return element.getLength() * element.getHeight() * countElement;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public int getCountElement() {
        return countElement;
    }

    public void setCountElement(int countElement) {
        this.countElement = countElement;
    }

    @Override
    public String toString() {
        return "Wall{" +
                "element=" + element +
                ", countElement=" + countElement +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wall wall = (Wall) o;
        return countElement == wall.countElement && Objects.equals(element, wall.element);
    }

    @Override
    public int hashCode() {
        return Objects.hash(element, countElement);
    }
}
