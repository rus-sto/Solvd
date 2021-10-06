package hw002.company.constructions;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

public class House {

    private static final int COST_HOUSE_EXTRA_AREA = 50;
    private static final int EXTRA_HOUSE_AREA = 15;
    private static final int COST_HOUSE_ROOF = 15;
    private static final int COST_HOUSE_GROUND = 9;
    private static final LocalTime EXTRA_TIME_PRODUCE_FOR_HOUSE = LocalTime.of(23, 35, 00);

    private Flat oneRoomFlat;
    private int countOneRoomFlat;
    private Flat twoRoomFlat;
    private int countTwoRoomFlat;
    private Flat threeRoomFlat;
    private int countThreeRoomFlat;
    private Date buildDate;
    private LocalDateTime startBuild;
    private LocalDateTime finishBuild;

    public House(Flat oneRoomFlat, int countOneRoomFlat, Flat twoRoomFlat,
                 int countTwoRoomFlat, Flat threeRoomFlat, int countThreeRoomFlat) {
        this.oneRoomFlat = oneRoomFlat;
        this.countOneRoomFlat = countOneRoomFlat;
        this.twoRoomFlat = twoRoomFlat;
        this.countTwoRoomFlat = countTwoRoomFlat;
        this.threeRoomFlat = threeRoomFlat;
        this.countThreeRoomFlat = countThreeRoomFlat;
    }

    public double totalHouseArea(double areaFlat, int countTwoRoomFlat) {
        String rez = String.format("%.2f", areaFlat * countTwoRoomFlat + EXTRA_HOUSE_AREA + countTwoRoomFlat * 2);
        System.out.println("Total House AREA is " + rez);
        return areaFlat * countTwoRoomFlat + EXTRA_HOUSE_AREA + countTwoRoomFlat * 2;
    }

    public double totalHouseCost(double costFlat, int countTwoRoomFlat, double areaFlat) {
        String rez = String.format("%.2f", costFlat * countTwoRoomFlat + COST_HOUSE_EXTRA_AREA +
                (COST_HOUSE_ROOF + COST_HOUSE_GROUND) * totalHouseArea(areaFlat,countTwoRoomFlat));
        System.out.println("Total COST of THE House  is " + rez);
        return costFlat * countTwoRoomFlat + COST_HOUSE_EXTRA_AREA +
                (COST_HOUSE_ROOF + COST_HOUSE_GROUND) * totalHouseArea(areaFlat,countTwoRoomFlat);
    }
    public long produceTimeOfHouse (long produceTimeOfFlat, int countTwoRoomFlat) {
        long totalHouseExtraSeconds = (long) ((EXTRA_TIME_PRODUCE_FOR_HOUSE.getHour() * 3600
                + EXTRA_TIME_PRODUCE_FOR_HOUSE.getMinute() * 60
                + EXTRA_TIME_PRODUCE_FOR_HOUSE.getSecond()) );
        long rez = produceTimeOfFlat * countTwoRoomFlat + totalHouseExtraSeconds;
        System.out.println("House quantity of seconds is  " + rez);
        int days = (int) (rez / 3600 / 24);
        int hour = (int) (rez / 3600 % 24);
        int min = (int) (rez / 60 % 60);
        int sec = (int) (rez / 1 % 60);
        System.out.println(String.format("%s days %s:%s:%s", days, hour, min, sec));
        return  rez;
    }

    public Flat getOneRoomFlat() {
        return oneRoomFlat;
    }

    public void setOneRoomFlat(Flat oneRoomFlat) {
        this.oneRoomFlat = oneRoomFlat;
    }

    public int getCountOneRoomFlat() {
        return countOneRoomFlat;
    }

    public void setCountOneRoomFlat(int countOneRoomFlat) {
        this.countOneRoomFlat = countOneRoomFlat;
    }

    public Flat getTwoRoomFlat() {
        return twoRoomFlat;
    }

    public void setTwoRoomFlat(Flat twoRoomFlat) {
        this.twoRoomFlat = twoRoomFlat;
    }

    public int getCountTwoRoomFlat() {
        return countTwoRoomFlat;
    }

    public void setCountTwoRoomFlat(int countTwoRoomFlat) {
        this.countTwoRoomFlat = countTwoRoomFlat;
    }

    public Flat getThreeRoomFlat() {
        return threeRoomFlat;
    }

    public void setThreeRoomFlat(Flat threeRoomFlat) {
        this.threeRoomFlat = threeRoomFlat;
    }

    public int getCountThreeRoomFlat() {
        return countThreeRoomFlat;
    }

    public void setCountThreeRoomFlat(int countThreeRoomFlat) {
        this.countThreeRoomFlat = countThreeRoomFlat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return countOneRoomFlat == house.countOneRoomFlat && countTwoRoomFlat == house.countTwoRoomFlat && countThreeRoomFlat == house.countThreeRoomFlat && Objects.equals(oneRoomFlat, house.oneRoomFlat) && Objects.equals(twoRoomFlat, house.twoRoomFlat) && Objects.equals(threeRoomFlat, house.threeRoomFlat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oneRoomFlat, countOneRoomFlat, twoRoomFlat, countTwoRoomFlat, threeRoomFlat, countThreeRoomFlat);
    }

    @Override
    public String toString() {
        return "House{" +
                "oneRoomFlat=" + oneRoomFlat +
                ", countOneRoomFlat=" + countOneRoomFlat +
                ", twoRoomFlat=" + twoRoomFlat +
                ", countTwoRoomFlat=" + countTwoRoomFlat +
                ", threeRoomFlat=" + threeRoomFlat +
                ", countThreeRoomFlat=" + countThreeRoomFlat +
                '}';
    }
}
