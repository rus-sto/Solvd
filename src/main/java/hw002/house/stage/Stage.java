package hw002.house.stage;

import hw002.house.dom.flat.Flat;
import hw002.house.room.Room;

import java.util.Arrays;

public class Stage {

    private Flat[] flats;
    private Boolean isPainted;

    public Stage(Flat[] flats, Boolean isPainted) {
        this.flats = flats;
        this.isPainted = isPainted;
    }

    public void cleaningStage() {
        System.out.println("The Stage is cleaned");
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
                "This stage has " + flats.length +
                "\nflats=" + Arrays.toString(flats) +
                ", isPainted=" + isPainted +
                '}';
    }
}
