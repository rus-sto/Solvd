package hw002.house.stage;

import hw002.house.Paintable;
import hw002.house.flat.Flat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Objects;

public class Stage implements Paintable {

    private static final Logger LOGGER = LogManager.getLogger(Stage.class);

    private Flat[] flats;
    private Boolean isPainted;

    public Stage(Flat[] flats, Boolean isPainted) {
        this.flats = flats;
        this.isPainted = isPainted;
    }

    public void cleaningStage() {
        LOGGER.debug("The Stage is cleaned");
    }

    public double stageWallsAreaCalc() {
        double stageWallsArea = 0;
        for (Flat flat : flats) {
            stageWallsArea += flat.flatWallsAreaCalc();
        }
        return stageWallsArea;
    }

    public double stageTimeProduceCalc() {
        double stageTimeProduce = 0;
        for (Flat flat : flats) {
            stageTimeProduce += flat.flatTimeProduceCalc();
        }
        return stageTimeProduce;
    }


    public Flat[] getFlats() {
        return flats;
    }

    public void setFlats(Flat[] flats) {
        this.flats = flats;
    }

    public Boolean getPainted() {
        return isPainted;
    }

    public void setPainted(Boolean painted) {
        isPainted = painted;
    }

    @Override
    public String toString() {
        return "\n\nStage{" +
                "This stage has " + flats.length + " flats " +
                "It has " + flats.length + " flats " +
                "\n And It can be produced for " + stageTimeProduceCalc() + " sec " +
                "\nflats=" + Arrays.toString(flats) +
                ", isPainted=" + isPainted +
                '}';
    }

    @Override
    public String toPaint() {
        if (isPainted) {
            return "the stage is already painted";
        } else {
            return "the stage can be painted in any color";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stage stage = (Stage) o;
        return Arrays.equals(flats, stage.flats);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(flats);
    }
}
