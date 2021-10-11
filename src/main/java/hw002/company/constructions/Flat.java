package hw002.company.constructions;

import hw002.company.PrintBlock;

import java.time.LocalTime;
import java.util.Objects;

public class Flat extends PrintBlock {

    private static final int COST_FLAT_EXTRA_AREA = 50;
    private static final int EXTRA_AREA_FLAT = 12;
    private static final LocalTime EXTRA_TIME_PRODUCE_FOR_FLAT = LocalTime.of(10, 00, 00);

    private int countRoom;
    private Room room;

    public Flat(int countRoom, Room room) {
        this.countRoom = countRoom;
        this.room = room;
    }

    public double areaFlat(int countRoom, double areaRoom) {
//        System.out.println(countRoom + " -room Flat Area is " + String.format("%.2f",countRoom * areaRoom + EXTRA_AREA_FLAT));
        return countRoom * areaRoom + EXTRA_AREA_FLAT;
    }

    public double costFlat(double TotalRoomCost, int countRoom) {
//        System.out.println("this FLAT  Total Cost is " + String.format("%.2f", TotalRoomCost * countRoom + COST_FLAT_EXTRA_AREA));
        return TotalRoomCost * countRoom + COST_FLAT_EXTRA_AREA;
    }

    public long produceTimeOfFlat(long produceTimeOfRoom, int countRoom) {
        long totalFlatExtraSeconds = (long) ((EXTRA_TIME_PRODUCE_FOR_FLAT.getHour() * 3600
                + EXTRA_TIME_PRODUCE_FOR_FLAT.getMinute() * 60
                + EXTRA_TIME_PRODUCE_FOR_FLAT.getSecond()));
        long rez = produceTimeOfRoom * countRoom + totalFlatExtraSeconds;
//        System.out.println("Flat quantity of seconds is  " + rez);
        return rez;
    }

    public int getCountRoom() {
        return countRoom;
    }

    public void setCountRoom(int countRoom) {
        this.countRoom = countRoom;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flat flat = (Flat) o;
        return countRoom == flat.countRoom && Objects.equals(room, flat.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countRoom, room);
    }

    @Override
    public String toString() {
        return "Flat{" +
                "countRoom=" + countRoom +
                ", room=" + room +
                '}';
    }

    @Override
    public void printInfo() {
        System.out.println("Each oneRoomFlat, twoRoomFlat and threeRoomFlat have rooms with flore area - " + room.getRoomSquare() +
                " m2; \n with " + room.getCountWindows() + " in each room");
    }
}
