package hw002.house.room;


import hw002.house.House002;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ceiling {

    private static final Logger LOGGER = LogManager.getLogger(Ceiling.class);

    private Boolean isLighted;
    private String color;

    public Ceiling(boolean isLighted, String color) {
        this.isLighted = isLighted;
        this.color = color;
    }

    public void printCeilInfo() {
        LOGGER.debug("This ceiling has " + color + " color");
    }

    public void printCeilInfo(Boolean isLighted) {
        LOGGER.debug("This ceiling has " + color + " color ; And It well lighted - " + isLighted);
    }

    public boolean isLighted() {
        return isLighted;
    }

    public void setLighted(boolean lighted) {
        isLighted = lighted;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Ceiling{" +
                "isLighted=" + isLighted +
                ", color='" + color + '\'' +
                '}';
    }
}
