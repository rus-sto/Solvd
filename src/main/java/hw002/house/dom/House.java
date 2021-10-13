package hw002.house.dom;


import hw002.house.House002;
import hw002.house.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.Objects;

public class House extends Building {

    private static final Logger LOGGER = LogManager.getLogger(House.class);

    private Stage stage;
    private int countStages;
    private String address;
    private LocalDateTime startBuild;
    private LocalDateTime finishBuild;

    public House(String form, String type, Stage stage, int countStages, String address) {
        super(form, type);
        this.stage = stage;
        this.countStages = countStages;
        this.address = address;
    }

    public double houseWallsAreaCalc() {
        double houseWallsArea = stage.stageWallsAreaCalc() * countStages;
        return houseWallsArea;
    }

    public long houseTimeProduceCalc() {
        startBuild = LocalDateTime.now();
        LOGGER.debug("If we start building - " + startBuild);
        long time = (long) stage.stageTimeProduceCalc() * countStages;
        LOGGER.debug("We need " + time + " seconds to build this house!");
        int days = (int) (time / 3600 / 24);
        int hour = (int) (time / 3600 % 24);
        int min = (int) (time / 60 % 60);
        int sec = (int) (time / 1 % 60);
        String timeToBuild = String.format("%s days %s:%s:%s", days, hour, min, sec);
        LOGGER.debug(timeToBuild);
        finishBuild = LocalDateTime.now().plusSeconds(time);
        LOGGER.debug("The building will be finished at " + finishBuild);
        return time;
    }

    @Override
    public void printBuildingType() {
        LOGGER.debug("This is " + getType());
    }

    @Override
    public void printConstrForm() {
        LOGGER.debug("Form of Construction is " + getForm());
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public int getCountStages() {
        return countStages;
    }

    public void setCountStages(int countStages) {
        this.countStages = countStages;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "\n\nThis House's{" +
                " address is " + address + '\'' +
                ",\n It has " + countStages + " Stages," +
                "\nThis house walls Total area is " + houseWallsAreaCalc() + "m2" +
                "\n Building time - " + houseTimeProduceCalc() +
                "\nstage=" + stage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return countStages == house.countStages && Objects.equals(stage, house.stage) && Objects.equals(address, house.address) && Objects.equals(startBuild, house.startBuild) && Objects.equals(finishBuild, house.finishBuild);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stage, countStages, address, startBuild, finishBuild);
    }
}
